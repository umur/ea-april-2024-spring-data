package com.brianmugalu.demo.controller;

import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.repository.entity.Product;
import com.brianmugalu.demo.repository.entity.Review;
import com.brianmugalu.demo.service.ProductService;
import com.brianmugalu.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/{id}")
    public Review addReview(@PathVariable(name = "id") Long productId,@RequestBody Review review){
        return reviewService.addReview(productId,review);
    }
    @PutMapping("/{id}")
    public Category updateComment(@PathVariable(name = "id") Long reviewId, @PathVariable String comment){
        return reviewService.updateComment(reviewId,comment);
    }

    @GetMapping("user/{id}")
    public Category getSingleReviewsByUserId(@PathVariable(name = "id") Long UserId){
        return  reviewService.getSingleReviewByUserId(UserId);
    }

    @GetMapping("product/{id}")
    public Category getReviewsByProductId(@PathVariable Long id){
        return  reviewService.getReviewsByProductId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id){
        return reviewService.deleteReview(id);
    }
}
