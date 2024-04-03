package com.david.lab.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Product APIs", description = "APIs for managing products")
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Tag(name = "Task 3 APIs", description = "Implement the following queries by using Naming Convention. Create REST endpoints for them.")
    @GetMapping("price")
    @Operation(summary = "Find all products that cost more than minPrice")
    public List<Product> getProductsByPriceGreaterThan(@RequestParam @Parameter(example = "200") BigDecimal minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @Tag(name = "Task 3 APIs", description = "Implement the following queries by using Naming Convention. Create REST endpoints for them.")
    @GetMapping("category")
    @Operation(summary = "Find all products in cat category and cost less than maxPrice")
    public List<Product> getProductsByPriceLessThanAndCategoryIs(@RequestParam @Parameter(example = "3000") BigDecimal maxPrice,
                                                                 @RequestParam @Parameter(example = "3") long categoryId) {
        return productService.findAllByPriceLessThanAndCategoryIs(maxPrice, categoryId);
    }

    @Tag(name = "Task 3 APIs", description = "Implement the following queries by using Naming Convention. Create REST endpoints for them.")
    @GetMapping("name")
    @Operation(summary = "Find all products that contain keyword in the name.")
    public List<Product> getProductsByNameContaining(@RequestParam @Parameter(example = "Shorthair") String keyword) {
        return productService.findByNameContaining(keyword);
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a product by Id")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Operation(summary = "Update an existing product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a product by Id")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}