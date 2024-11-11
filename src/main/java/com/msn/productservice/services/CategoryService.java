package com.msn.productservice.services;

import com.msn.productservice.dtos.FakeStoreProductDTO;

import java.util.List;

public interface CategoryService {
    public List<FakeStoreProductDTO> getInCategory(String category);
    public List<String> getAllCategories();
}
