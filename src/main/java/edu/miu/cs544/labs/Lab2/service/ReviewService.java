package edu.miu.cs544.labs.Lab2.service;

import edu.miu.cs544.labs.Lab2.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();

    Optional<Review> findById(Long id);

    void save(Review review);

    void delete(Long id);

    void update(Review review);

    List<Review> findReviewsByProductId(Long productId);
}
