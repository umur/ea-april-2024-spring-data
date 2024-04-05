package com.example.labData.Service;

import com.example.labData.Entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Optional<Review> findById(long id);
    void save(Review review);
    void update(Review review);
    void delete(long id);
    List<Review> findAllByProduct_Id(long id);
}
