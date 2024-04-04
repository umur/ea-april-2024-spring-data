package com.brianmugalu.demo.controller;

import com.brianmugalu.demo.repository.entity.Product;
import com.brianmugalu.demo.repository.entity.Review;
import com.brianmugalu.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/{id}")
    public Product addProduct(@RequestBody Product product,@PathVariable Long id){
        return productService.addProduct(product,id);
    }
    @PutMapping("name/{id}/{name}")
    public Product updateCategoryName(@PathVariable Long id, @PathVariable String name){
        return productService.updateCategoryName(id,name);
    }

    @PutMapping("price/{id}/{price}")
    public Product updateProductPrice(@PathVariable Long id,@PathVariable Double price){
        return productService.updateProductPrice(id,price);
    }

    @PutMapping("rating/{id}/{rating}")
    public Product updateProductRating(@PathVariable Long id,@PathVariable Integer rating){
        return productService.updateProductRating(id,rating);
    }

    @GetMapping("/{id}")
    public Product getSingleProductById(@PathVariable Long id){
        return productService.getSingleProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping
    public List<Product> getAllProductsByMinPrice(@RequestParam(name="minPrice") Double price){
        return productService.getAllProductsByMinPrice(price);
    }

    @GetMapping("/category/{cat}")
    public List<Product> getAllProductCostLess(@RequestParam(name = "maxPrice") Double price,@PathVariable(name = "cat") String category){
        return productService.getAllProductCostLess(category,price);
    }

    @GetMapping("/query")
    public List<Product> getAllProductsContaining(@RequestParam String key){
        return productService.getAllProductsContaining(key);
    }

    @GetMapping("/reviews/{id}")
    public List<Review> getAllReviewsByProductId(@PathVariable Long id){
        return productService.getAllReviewsByProductId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        return  productService.deleteProductById(id);
    }

}
