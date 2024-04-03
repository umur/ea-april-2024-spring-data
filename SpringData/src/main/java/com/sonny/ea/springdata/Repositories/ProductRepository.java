package com.sonny.ea.springdata.Repositories;

import com.sonny.ea.springdata.Entities.Category;
import com.sonny.ea.springdata.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(Float minPrice);
    List<Product> findAllByCategoryEqualsAndPriceLessThan(Category cat, Float maxPrice);

    List<Product> findAllByNameContainingIgnoreCase(String keyword);
}
