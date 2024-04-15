package com.ea.springjpa.repository;

import com.ea.springjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Collection<Product> findByPriceGreaterThan(BigDecimal minPrice);

    @Query("select p from Product p where p.category.id = ?1 and p.price < ?2")
    Collection<Product> findByCategoryIdAndPriceLessThan(Long categoryId, BigDecimal maxPrice);

    Collection<Product> findByNameContaining(String keyword);
}
