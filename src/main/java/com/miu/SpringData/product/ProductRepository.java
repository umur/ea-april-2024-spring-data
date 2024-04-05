package com.miu.SpringData.product;

import com.miu.SpringData.category.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(double minPrice);

    List<Product> findByCategoryAndPriceLessThan(Category category, double maxPrice);

    List<Product> findByNameContaining(String searchName);
}
