package com.example.labData.Repository;

import com.example.labData.Entity.Category;
import com.example.labData.Entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(double minPrice);
    List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice);
    List<Product> findAllByNameContains(String keyword);
}
