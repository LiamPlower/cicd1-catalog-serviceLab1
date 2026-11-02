package com.example.lab1.controller;

import com.example.lab1.dto.CreateProductRequest;
import com.example.lab1.model.Products;
import com.example.lab1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/{id}")
    public Products getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/min-price")
    public List<Products>getByMinimumPrice(@RequestParam("price") BigDecimal price)
    {
        return productService.getByMinimumPrice(price);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Products createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/by-category")
    public List<Products> getByCategory(
            @RequestParam("name") String categoryName) {
        return productService.getByCategoryName(categoryName);
    }
}
