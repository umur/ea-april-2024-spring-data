package com.david.lab.review;

import com.david.lab.product.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Review APIs", description = "APIs for managing reviews")
@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @Tag(name = "Task 3 APIs", description = "Implement the following queries by using Naming Convention. Create REST endpoints for them.")
    @GetMapping("product/{productId}")
    @Operation(summary = "Get reviews by product")
    public List<Review> getReviewsByProduct(@PathVariable @Parameter(example = "4") Long productId) {
        Product product = new Product();
        product.setId(productId);
        return reviewService.findByReviewedProduct(product);
    }

    @PostMapping
    @Operation(summary = "Create a new review")
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a review by Id")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        return reviewService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Operation(summary = "Update an existing review")
    public Review updateReview(@Param(value = "Updated review object") @RequestBody Review review) {
        return ResponseEntity.ok(reviewService.update(review)).getBody();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a review by Id")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}