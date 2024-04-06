package com.example.springdata1.services;

import com.example.springdata1.domain.Review;
import com.example.springdata1.dto.ReviewRequest;
import com.example.springdata1.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReviewById(long id){
        return reviewRepository.findById(id).get();
    }

    public Review updateReview(long id, ReviewRequest reviewRequest){
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if(existingReview != null){
            existingReview.setComment(reviewRequest.getComment());

            return reviewRepository.save(existingReview);
        }
        return null;
    }

    public void deleteReviewById(long id){
        reviewRepository.deleteById(id);
    }


    //Naming Convention

    public List<Review> getReviewsByProductId(long productId) {
        return reviewRepository.findByProductId(productId);
    }

}
