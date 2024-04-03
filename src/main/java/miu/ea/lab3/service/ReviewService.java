package miu.ea.lab3.service;

import miu.ea.lab3.model.Product;
import miu.ea.lab3.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    Review update(Review review);
    void delete(Long id);
    List<Review> getAll();
    List<Review> getReviewsByProductId(Long id);

}
