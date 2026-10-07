package com.example.lab1.controller;

import com.example.lab1.model.Products;
import com.example.lab1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getAll()
    {
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody Products product)
    {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Products getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}
