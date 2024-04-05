package com.example.labData.Service;

import com.example.labData.Entity.Category;
import com.example.labData.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(long id);
    void save(Product product);
    void update(Product product);
    void delete(long id);
    List<Product> findAllByPriceGreaterThan(double minPrice);
    List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice);
    List<Product> findAllByNameContains(String keyword);


}

