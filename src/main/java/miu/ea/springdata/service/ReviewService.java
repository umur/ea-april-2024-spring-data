package miu.ea.springdata.service;

import miu.ea.springdata.entity.Review;
import miu.ea.springdata.entity.User;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview();

    Review addReview(Review review);

    Review updateReview(Review review);

    void deleteReview(Long id);

    List<Review> getAllReviewOfProduct(Long id);
}
