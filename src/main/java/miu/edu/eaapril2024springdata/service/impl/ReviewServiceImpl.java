package miu.edu.eaapril2024springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Review;
import miu.edu.eaapril2024springdata.repository.ReviewRepository;
import miu.edu.eaapril2024springdata.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review getById(Long id) {
        return reviewRepository.getById(id);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void add(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void update(Long id, Review review) {
        Review r = reviewRepository.getById(id);
        r.setComment(review.getComment());
        reviewRepository.save(r);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review getByProductId(Long id) {
        return reviewRepository.getByProductId(id);
    }
}
