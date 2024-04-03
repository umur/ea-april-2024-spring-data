package edu.miu.cs544.labs.Lab2.service;

import edu.miu.cs544.labs.Lab2.entity.Review;
import edu.miu.cs544.labs.Lab2.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepo.findById(id);
    }

    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public void update(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public List<Review> findReviewsByProductId(Long productId) {
        return reviewRepo.findReviewsByProductId(productId);
    }
}
