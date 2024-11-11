package com.msn.productservice.services;

import com.msn.productservice.dtos.FakeStoreProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServicing implements CategoryService {
    private RestTemplate restTemplate;
    public CategoryServicing(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<FakeStoreProductDTO> getInCategory(String category) {
        var products = restTemplate.getForEntity("https://fakestoreapi.com/products/category/"+category, FakeStoreProductDTO[].class);
        if(products.getStatusCode().is5xxServerError()){
            throw new RuntimeException("Something went wrong.");
        }
        if (products.getBody().length == 0){
            throw new RuntimeException("No Product in this category");
        }
        return Arrays.stream(products.getBody()).toList();
    }

    @Override
    public List<String> getAllCategories() {
        var categories = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        if(categories.getStatusCode().is5xxServerError()) {
            throw new RuntimeException("Categories not found");
        }
        if(categories.getStatusCode().isError()){
            throw new RuntimeException("Error in fetching categories");
        }
        return Arrays.stream(Objects.requireNonNull(categories.getBody())).toList();
    }

}
