package com.example.labData.Service;

import com.example.labData.Entity.Review;
import com.example.labData.Repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo repo;
    @Override
    public List<Review> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Review> findById(long id) {

        return repo.findById(id);
    }

    @Override
    public void save(Review review) {
        repo.save(review);
    }

    @Override
    public void update(Review review) {
        repo.save(review);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Review> findAllByProduct_Id(long id) {
        return repo.findAllByProduct_Id(id);
    }
}
