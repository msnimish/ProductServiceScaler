package com.msn.productservice.controllers;

import com.msn.productservice.dtos.FakeStoreProductDTO;
import com.msn.productservice.services.CategoryServicing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryServicing categoryServicing;

    public CategoryController(CategoryServicing categoryServicing){
        this.categoryServicing = categoryServicing;
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<FakeStoreProductDTO>> getInCategory(@PathVariable("category") String category){
        return ResponseEntity.ok(categoryServicing.getInCategory(category));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories(){
        return ResponseEntity.ok(categoryServicing.getAllCategories());
    }
}
