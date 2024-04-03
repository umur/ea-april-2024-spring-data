package com.sonny.ea.springdata.Controllers;

import com.sonny.ea.springdata.Entities.Product;
import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping
    List<Review> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    Review get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    void add(@RequestBody Review newObj) {
        service.add(newObj);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody Review newObj) {
        service.update(id, newObj);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
