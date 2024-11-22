package com.msn.productservice.services;

import com.msn.productservice.dtos.FakeStoreProductDTO;
import com.msn.productservice.models.Category;
import com.msn.productservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        FakeStoreProductDTO[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );
        if (response == null) throw new AssertionError();
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeProduct : response) {
            products.add(fakeProduct.toProduct());
        }

        return products;
    }
    @Override
    public Product getProductDetails(Long id) {
        // TODO Auto-generated method stub
        ResponseEntity<FakeStoreProductDTO> response =  restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class
        );

        if(response.getStatusCode().is4xxClientError()) {
            throw new RuntimeException("Product not found");
        }
        return Objects.requireNonNull(response.getBody()).toProduct();
    }
    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        FakeStoreProductDTO fakeProduct = new FakeStoreProductDTO();
        fakeProduct.setTitle(product.getTitle());
        fakeProduct.setPrice(String.valueOf(product.getPrice()));
        fakeProduct.setDescription(product.getDescription());
        fakeProduct.setImage(product.getImageUrl());
        Category category = product.getCategory();
        fakeProduct.setCategory(category.getName());

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                fakeProduct,
                FakeStoreProductDTO.class);
        if(response.getStatusCode().is5xxServerError()){
            throw new RuntimeException("Error while saving product.");
        }
        return Objects.requireNonNull(response.getBody()).toProduct();
    }


}
