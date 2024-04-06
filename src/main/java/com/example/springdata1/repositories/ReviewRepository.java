package com.example.springdata1.repositories;


import com.example.springdata1.domain.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepository extends ListCrudRepository<Review, Long> {
    List<Review> findByProductId(long productId);
}
