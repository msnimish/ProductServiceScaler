package com.msn.productservice.controllers;

import com.msn.productservice.dtos.CreateProductRequestDTO;
import com.msn.productservice.models.Product;
import com.msn.productservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductDetails(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProductDetails(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDTO product){
        return ResponseEntity.ok(productService.createProduct(product.toProduct()));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody CreateProductRequestDTO product){
        return ResponseEntity.ok(productService.createProduct(product.toProduct()));
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> patchProduct(@RequestBody CreateProductRequestDTO product){
        return ResponseEntity.ok(productService.createProduct(product.toProduct()));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@RequestBody CreateProductRequestDTO product){
        return ResponseEntity.ok(productService.createProduct(product.toProduct()));
    }
}
