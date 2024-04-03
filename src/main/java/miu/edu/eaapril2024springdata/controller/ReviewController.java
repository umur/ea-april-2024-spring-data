package miu.edu.eaapril2024springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.Review;
import miu.edu.eaapril2024springdata.service.AddressService;
import miu.edu.eaapril2024springdata.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("{id}")
    public Review getById(@PathVariable Long id) {
        return reviewService.getById(id);
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Review review) {
        reviewService.add(review);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Review review) {
        reviewService.update(id, review);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @GetMapping("product/{id}")
    public Review getByProductId(Long id) {
        return reviewService.getByProductId(id);
    }

}
