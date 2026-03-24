package com.example.productjpql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productjpql.entity.Product;
import com.example.productjpql.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    @GetMapping("/products/filter")
    public List<Product> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    @GetMapping("/products/sorted")
    public List<Product> getSortedProducts() {
        return productRepository.getProductsSortedByPrice();
    }

    @GetMapping("/products/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return productRepository.getProductsAbovePrice(price);
    }

    @GetMapping("/products/categoryjpql/{category}")
    public List<Product> getByCategoryJPQL(@PathVariable String category) {
        return productRepository.getProductsByCategoryJPQL(category);
    }
}