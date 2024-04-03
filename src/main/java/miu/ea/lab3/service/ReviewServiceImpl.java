package miu.ea.lab3.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Product;
import miu.ea.lab3.model.Review;
import miu.ea.lab3.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        Review existingReview = reviewRepository.findById(review.getId()).orElseThrow(
                () -> new RuntimeException("Review does not exist: " + review.getId())
        );
        existingReview.setComment(review.getComment());
        reviewRepository.save(existingReview);
        return existingReview;
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }
}
