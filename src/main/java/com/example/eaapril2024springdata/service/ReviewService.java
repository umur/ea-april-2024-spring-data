package com.example.eaapril2024springdata.service;

import com.example.eaapril2024springdata.model.Review;

import java.util.List;

public interface ReviewService {
    Review create(Review review);
    Review findById(Long id);

    Review save(Review review);

    Review update(Long id, Review review);

    void deleteById(Long id);

    List<Review> findAll();

    List<Review> findAllByProductId(Long productId);
}
