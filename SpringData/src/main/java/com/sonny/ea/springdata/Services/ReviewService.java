package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review getById(Long id);
    void update(Long id, Review newObj);
    void add(Review newObj);
    void delete(Long id);
}
