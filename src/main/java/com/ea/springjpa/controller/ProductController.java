package com.ea.springjpa.controller;

import com.ea.springjpa.request.ProductRequest;
import com.ea.springjpa.response.ProductResponse;
import com.ea.springjpa.response.ReviewResponse;
import com.ea.springjpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;



    @PostMapping
    public ProductResponse createProduct(ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }


    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/greater-than-min-price")
    public List<ProductResponse> getProductsGreaterThanMinPrice(@RequestParam BigDecimal minPrice) {
        return productService.getProductsGreaterThanMinPrice(minPrice);
    }


    @GetMapping("/less-than-max-price")
    public List<ProductResponse> getProductsLessThanMaxPrice(@RequestParam Long categoryId, @RequestParam BigDecimal maxPrice) {
        return productService.getProductsLessThanMaxPrice(categoryId, maxPrice);
    }


    @GetMapping("/search")
    public List<ProductResponse> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }


    @GetMapping("/{id}/reviews")
    public List<ReviewResponse> getReviews(@PathVariable Long id) {
        return productService.getReviews(id);
    }

}
