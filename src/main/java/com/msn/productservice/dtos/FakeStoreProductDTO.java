package com.msn.productservice.dtos;

import com.msn.productservice.models.Category;
import com.msn.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;

    public Product toProduct() {
        Product p = new Product();
        p.setId(getId());
        p.setTitle(getTitle());
        p.setDescription(getDescription());
        p.setPrice(Double.parseDouble(getPrice()));
        p.setImageUrl(getImage());
        Category category = new Category();
        category.setName(getCategory());
        p.setCategory(category);
        return p;
    }
}
