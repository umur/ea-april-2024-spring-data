package edu.miu.cs544.labs.Lab2.repository;

import edu.miu.cs544.labs.Lab2.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepo extends ListCrudRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, double price);

    List<Product> findByNameContains(String name);
}
