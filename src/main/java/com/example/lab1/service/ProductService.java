package com.example.lab1.service;

import com.example.lab1.model.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    private final List<Products> products = new ArrayList<>();
    private long nextId = 1;

    public List<Products> getAll()
    {
        return products;
    }

    public Products create (Products product)
    {
        product.setId(nextId++);
    }
}
