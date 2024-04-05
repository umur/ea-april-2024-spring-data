package com.example.labData.Controller;

import com.example.labData.Entity.Review;
import com.example.labData.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService service;

    @GetMapping("/")
    public List<Review> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Review findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Review review) {
        service.save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Review review) {
        service.update(review);
    }

    @GetMapping("/getByProductId")
    public List<Review> findAllByProduct_Id(long id){
        return service.findAllByProduct_Id(id);
    }
}
