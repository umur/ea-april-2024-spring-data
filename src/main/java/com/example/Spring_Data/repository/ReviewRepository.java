package com.example.Spring_Data.repository;

import com.example.Spring_Data.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
}
