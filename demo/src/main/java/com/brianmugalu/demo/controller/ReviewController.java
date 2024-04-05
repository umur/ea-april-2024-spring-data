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

    @PostMapping("/{id}?userId")
    public Review addReview(@PathVariable(name = "id") Long productId,@RequestBody Review review,@RequestParam Long userId){
        return reviewService.addReview(productId,review,userId);
    }
    @PutMapping("/{id}?userId")
    public Review updateComment(@PathVariable(name = "id") Long reviewId, @RequestBody String comment,@RequestParam Long userId){
        return reviewService.updateComment(reviewId,comment,userId);
    }



    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id){
        return reviewService.deleteReview(id);
    }
}
