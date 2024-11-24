package com.msn.productservice.services;

import com.msn.productservice.models.Category;
import com.msn.productservice.models.Product;
import com.msn.productservice.repositories.CategoryRepository;
import com.msn.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("databaseProductService")
//@Primary  --use this when @Qualifier is not preferred or some reason... Qualifier needs names to be provided to various services
public class DatabaseProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DatabaseProductService(ProductRepository productRepository,
                                  CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductDetails(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category categoryFromDB = categoryRepository.findByName(product.getCategory().getName());
        if(categoryFromDB == null){
            Category category = new Category();
            category.setName(product.getCategory().getName());
            categoryFromDB = categoryRepository.save(category);
        }

        product.setCategory(categoryFromDB);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, long id) {
        return null;
    }

    @Override
    public Product patchProduct(Product product, long id) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }
}
