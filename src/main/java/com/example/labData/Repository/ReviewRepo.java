package com.example.labData.Repository;

import com.example.labData.Entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    List<Review> findAllByProduct_Id(long id);
}
