package com.example.lab1.repository;

import com.example.lab1.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long>
{

    @Query(" SELECT p FROM Products p JOIN p.category c WHERE LOWER(c.name) = LOWER(:categoryName) ORDER BY p.price ASC")
    List<Products> findByCategoryName(@Param("categoryName") String categoryName);


    @Query("SELECT p FROM Products p WHERE p.price >= :minPrice ORDER BY p.price ASC")
    List<Products> findByMinimumPrice(@Param("minPrice") BigDecimal minPrice);
}
