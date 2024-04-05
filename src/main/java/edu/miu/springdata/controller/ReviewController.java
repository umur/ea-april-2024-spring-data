package edu.miu.springdata.controller;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Review;
import edu.miu.springdata.service.ReviewService;
import edu.miu.springdata.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor

public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public Review save(@RequestBody Review review){
        return reviewService.save(review);
    }

    @GetMapping
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id, @RequestBody Review review){
        return reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        reviewService.deleteById(id);
    }

    @GetMapping("/product/{id}")
    public List<Review> getReviewsByProductId(@PathVariable long id){return reviewService.getReviewsByProductId(id); }
}
