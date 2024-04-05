package edu.miu.springdata.service;

import edu.miu.springdata.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    Review save(Review review);

    boolean update(long id, Review review);

    void deleteById(long id);

    List<Review> getReviewsByProductId(long id);


}
