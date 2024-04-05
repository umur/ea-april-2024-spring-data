package com.brianmugalu.demo.repository.dto;

import com.brianmugalu.demo.repository.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Long> {

}
