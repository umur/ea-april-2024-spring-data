package edu.miu.cs544.labs.Lab2.repository;

import edu.miu.cs544.labs.Lab2.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    List<Review> findReviewsByProductId(Long productId);
}
