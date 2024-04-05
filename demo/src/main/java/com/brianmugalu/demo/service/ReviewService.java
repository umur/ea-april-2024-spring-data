package com.brianmugalu.demo.service;

import com.brianmugalu.demo.repository.dto.ProductRepo;
import com.brianmugalu.demo.repository.dto.ReviewRepo;
import com.brianmugalu.demo.repository.dto.UserRepo;
import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.repository.entity.Product;
import com.brianmugalu.demo.repository.entity.Review;
import com.brianmugalu.demo.repository.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    @Transactional
    public Review addReview(Long productId, Review review, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));
        Product product = productRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found"));
        user.addReview(review);
        product.addReview(review);
        return review;
    }

    @Transactional
    public Review updateComment(Long id, String comment, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));
        Review review = reviewRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Review with id " + id + " not found"));
        review.setComment(comment);
        return review;
    }

    public String deleteReview(Long id) {
        reviewRepo.deleteById(id);
        return "Deleted Successfully";
    }

}
