package com.example.lab1.controller;

import com.example.lab1.model.Products;
import com.example.lab1.service.ProductService;
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
    public Products create(@RequestBody Products product)
    {
        return productService.create(product);
    }
}
