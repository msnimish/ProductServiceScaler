package com.msn.productservice.dtos;

import com.msn.productservice.models.Category;
import com.msn.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDTO {
    public String title;
    public String description;
    public String image;
    public double price;
    public String category;
    public String id;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageUrl(getImage());
        Category category = new Category();
        category.setName(getCategory());
        product.setCategory(category);
        return product;
    }
}
