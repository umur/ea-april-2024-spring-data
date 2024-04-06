package com.example.springdata1.controller;


import com.example.springdata1.domain.Review;
import com.example.springdata1.dto.ReviewRequest;
import com.example.springdata1.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @Operation(summary = "Saves a review", description = "This API will save the review")
    @PostMapping
    public ResponseEntity<Review> createReview(Review review){
        Review savedReview = reviewService.createReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all reviews", description = "This API will fetch all the reviews available")
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @Operation(summary = "Gets a review by id", description = "This API will fetch a review using id")
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable long id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @Operation(summary = "Updates a review", description = "This API will update the review and its attributes")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable long id, @RequestBody ReviewRequest reviewRequest){
        reviewService.updateReview(id, reviewRequest);
        return ResponseEntity.ok("Review updated successfully");
    }

    @Operation(summary = "Deletes a review", description = "This API will delete a review by the given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable long id){
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully");
    }


    @Operation(summary = "Gets reviews by product id")
    @GetMapping("/byProductId/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }


}
