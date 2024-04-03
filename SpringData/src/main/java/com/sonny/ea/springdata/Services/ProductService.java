package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Product;
import com.sonny.ea.springdata.Entities.Review;

import java.util.List;

public interface ProductService {
    List<Product> getProductsWithMinPrice(Float minPrice);
    List<Product> getProductsByCategoryWithMaxPrice(Long categoryId, Float maxPrice);
    List<Product> getProductsContainKeyword(String keyword);
    List<Review> getReviewsOfProduct(Long productId);

    List<Product> getAll();
    Product getById(Long id);
    void update(Long id, Product product);
    void add(Product product);
    void delete(Long id);
}
