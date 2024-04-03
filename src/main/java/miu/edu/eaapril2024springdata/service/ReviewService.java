package miu.edu.eaapril2024springdata.service;

import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.Review;

import java.util.List;

public interface ReviewService {
    Review getById(Long id);
    List<Review> getAll();
    void add(Review review);
    void update(Long id, Review review);
    void delete(Long id);

    Review getByProductId(Long id);
}
