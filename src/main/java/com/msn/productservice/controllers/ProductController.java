package com.msn.productservice.controllers;

import com.msn.productservice.dtos.CreateProductRequestDTO;
import com.msn.productservice.dtos.ErrorDto;
import com.msn.productservice.models.Product;
import com.msn.productservice.services.ProductService;
import com.msn.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("databaseProductService") ProductService productService){
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
    public ResponseEntity<Product> updateProduct(@RequestBody CreateProductRequestDTO product, @PathVariable("id") Long id){
        return ResponseEntity.ok(productService.updateProduct(product.toProduct(), id));
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> patchProduct(@RequestBody CreateProductRequestDTO product, @PathVariable("id") long id){
        return ResponseEntity.ok(productService.patchProduct(product.toProduct(), id));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }


    // This exception is specific to this controller so added here directly not in the Controller Advice
    @ExceptionHandler(ProductNotFoundException.class)
    public  ResponseEntity<ErrorDto> handlePNFException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Product not found");
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(500));

        return responseEntity;
    }
}
