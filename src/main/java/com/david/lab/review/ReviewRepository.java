package com.david.lab.review;

import com.david.lab.product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByReviewedProduct(Product product);
}