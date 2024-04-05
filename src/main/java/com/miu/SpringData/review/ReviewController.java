package com.miu.SpringData.review;

import com.miu.SpringData.product.Product;
import com.miu.SpringData.product.ProductDTO;
import com.miu.SpringData.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Review>> index() {

        return ResponseEntity.ok(this.reviewService.getReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getDetails(@PathVariable long id) {
        return ResponseEntity.ok(this.reviewService.getReview(id));
    }

    @PostMapping("/new")
    public ResponseEntity<String> newProduct(@RequestBody ReviewDTO productDTO) {

        return ResponseEntity.ok(this.reviewService.newReview(productDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody ReviewDTO productDTO) {

        return ResponseEntity.ok(this.reviewService.updateReview(productDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody ReviewDTO productDTO) {

        return ResponseEntity.ok(this.reviewService.deleteReview(productDTO));
    }

    @GetMapping("/reviews-of-product")
    public ResponseEntity<List<Review>> getReviewsOfProduct(@RequestParam Long id) {

        return ResponseEntity.ok(this.reviewService.getReviewsOfProduct(id));
    }
}
