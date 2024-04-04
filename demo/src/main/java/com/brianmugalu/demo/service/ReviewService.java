package com.brianmugalu.demo.service;

import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.repository.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ReviewService {

    public Review addReview(Long productId, Review review) {
    }

    public Category updateComment(Long id, String comment) {
    }

    public Category getSingleReviewByUserId(Long id) {
    }

    public Category getReviewsByProductId(Long id) {
    }

    public String deleteReview(Long id) {
    }
}
