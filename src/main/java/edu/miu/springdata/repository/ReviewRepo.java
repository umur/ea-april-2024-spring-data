package edu.miu.springdata.repository;

import edu.miu.springdata.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    public List<Review> getReviewsByProductId(long id);
}
