package com.example.lab1.service;

import com.example.lab1.dto.CreateProductRequest;
import com.example.lab1.model.Category;
import com.example.lab1.model.Products;
import com.example.lab1.repository.CategoryRepository;
import com.example.lab1.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;



    public List<Products> getAll()
    {
        return productRepository.findAll();
    }

    public Products create (Products product)
    {
        product.setId(null);
        // null for now, we use DTO's next week so this will disappear naturally
        return productRepository.save(product);
    }
    public Products getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
    public List<Products>getByMinimumPrice(BigDecimal minPrice) {
        return productRepository.findByMinimumPrice(minPrice);
    }

    public ProductService(ProductRepository repository,
                          CategoryRepository categoryRepository) {
        this.productRepository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Products createProduct(CreateProductRequest request) {
        if (request.categoryId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "categoryId is required");
        }
        Category category = categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Category does not exist"));
        Products product = new Products();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return productRepository.save(product);
    }

    public List<Products> getByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

}
