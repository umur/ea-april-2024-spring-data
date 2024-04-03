package com.sonny.ea.springdata.Controllers;

import com.sonny.ea.springdata.Entities.Category;
import com.sonny.ea.springdata.Entities.Product;
import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    Product get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    void add(@RequestBody Product newObj) {
        service.add(newObj);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody Product newObj) {
        service.update(id, newObj);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/min-price/{minPrice}")
    List<Product> search(@PathVariable Float minPrice) {
        return service.getProductsWithMinPrice(minPrice);
    }

    @GetMapping("/category/{cat}/max-price/{maxPrice}")
    List<Product> search2(@PathVariable Long cat,@PathVariable Float maxPrice) {
        return service.getProductsByCategoryWithMaxPrice(cat, maxPrice);
    }

    @GetMapping("/{id}/reviews")
    List<Review> getReviews(@PathVariable Long id) {
        return service.getReviewsOfProduct(id);
    }

    @GetMapping("/name/{keyword}")
    List<Product> getReviews(@PathVariable String keyword) {
        return service.getProductsContainKeyword(keyword);
    }
}
