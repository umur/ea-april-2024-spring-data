package com.example.eaapril2024springdata.service;


import com.example.eaapril2024springdata.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product findById(Long id);

    void deleteById(Long id);

    Product update(Long id, Product product);

    List<Product> findAll();

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);

    List<Product> findAllByNameContaining(String keyword);
}
