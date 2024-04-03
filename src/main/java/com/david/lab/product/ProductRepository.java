package com.david.lab.product;

import com.david.lab.category.Category;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(BigDecimal minPrice);
    List<Product> findAllByPriceLessThanAndCategoryIs(BigDecimal maxPrice, Category category);
    List<Product> findByNameContaining(String keyword);
}