package com.msn.productservice.dtos;

import com.msn.productservice.models.Category;
import com.msn.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateProductRequestDTO {
    public String title;
    public String description;
    public String image;
    public double price;
    public String category;

    public Product toProduct() {
        Product p = new Product();
        p.setTitle(getTitle());
        p.setDescription(getDescription());
        p.setPrice(getPrice());
        p.setImageUrl(getImage());
        Category category = new Category();
        category.setName(getCategory());
        p.setCategory(category);
        return p;
    }
}
