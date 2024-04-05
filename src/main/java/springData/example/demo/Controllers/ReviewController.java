package springData.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springData.example.demo.Service.ReviewService;
import springData.example.demo.domain.Review;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id){
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public void createReview(@RequestBody Review review){
        reviewService.createReview(review);
    }

    @PutMapping
    public void updateReview(@RequestBody Review review){
       reviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable long id){
       reviewService.deleteReviewById(id);
    }

    @GetMapping("/product/{id}")
    List<Review> findAllByProduct_Id(@PathVariable long id){
        return reviewService.findAllByProduct_Id(id);
    }
}
