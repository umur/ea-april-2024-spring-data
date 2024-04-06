package com.example.springdata1.repositories;


import com.example.springdata1.domain.Category;
import com.example.springdata1.domain.Product;
import com.example.springdata1.domain.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryAndPriceLessThan(Category category, double maxPrice);
    List<Product> findProductByNameContaining(String keyword);


}
