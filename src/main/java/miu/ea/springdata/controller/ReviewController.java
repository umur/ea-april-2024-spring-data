package miu.ea.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Review;
import miu.ea.springdata.entity.User;
import miu.ea.springdata.service.ReviewService;
import miu.ea.springdata.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    //CRUD of Product
    //Get all address
    @GetMapping
    public ResponseEntity<List<Review>> getAllReview(){
        List<Review> result = reviewService.getAllReview();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Create Address
    @PostMapping
    public ResponseEntity<Review> addUser(@RequestBody Review review){
        Review result = reviewService.addReview(review);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Update Address
    @PutMapping
    public ResponseEntity<Review> updateReview(@RequestBody Review review){
        Review result = reviewService.updateReview(review);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Delete Address
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
        return "Delete Successfully ";
    }

    //Delete Address
    @GetMapping("/find-by-product/{id}")
    public ResponseEntity<List<Review>> getAllReviewOfProduct(@PathVariable Long id){
        List<Review> result = reviewService.getAllReviewOfProduct(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
