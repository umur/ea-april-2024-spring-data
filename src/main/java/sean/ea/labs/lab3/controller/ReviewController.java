package sean.ea.labs.lab3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sean.ea.labs.lab3.entity.Review;
import sean.ea.labs.lab3.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> fetchAll() {
        return reviewService.getAll();
    }

    @GetMapping("/reviews/{id}")
    public Review fetchOne(@PathVariable Long id) {
        return reviewService.get(id);
    }

    @PostMapping("/users/{userId}/products/{productId}/reviews")
    public void create(@PathVariable Long userId, @PathVariable Long productId, @RequestBody Review review) {
        reviewService.create(userId, productId, review);
    }

    @PutMapping("/reviews/{id}")
    public void update(@PathVariable Long id, @RequestBody Review review) {
        reviewService.update(id, review);
    }

    @DeleteMapping("/reviews/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
