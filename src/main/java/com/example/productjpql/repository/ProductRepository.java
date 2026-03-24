package com.example.productjpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.productjpql.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getProductsAbovePrice(@Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getProductsByCategoryJPQL(@Param("category") String category);
}