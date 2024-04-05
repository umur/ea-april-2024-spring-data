package com.example.eaapril2024springdata.reponsitory;

import com.example.eaapril2024springdata.model.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review,Long> {
    List<Review> findAllByProductId(Long productId);
}