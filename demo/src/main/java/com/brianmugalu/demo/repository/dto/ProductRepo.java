package com.brianmugalu.demo.repository.dto;

import com.brianmugalu.demo.repository.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo  extends ListCrudRepository<Product,Long> {
    List<Product> findAllByPriceGreaterThan(Double price);
    List<Product> findAllByCategory(String name);

    List<Product> findProductByNameContaining(String key);

}
