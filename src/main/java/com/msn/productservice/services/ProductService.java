package com.msn.productservice.services;

import com.msn.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductDetails(Long id);
    public Product createProduct(Product product);
}
