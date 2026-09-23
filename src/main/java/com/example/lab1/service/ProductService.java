package com.example.lab1.service;

import com.example.lab1.model.Products;
import com.example.lab1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

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
}
