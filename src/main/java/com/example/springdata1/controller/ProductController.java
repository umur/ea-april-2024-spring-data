package com.example.springdata1.controller;

import com.example.springdata1.domain.Product;
import com.example.springdata1.dto.ProductRequest;
import com.example.springdata1.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @Operation(summary = "Saves a product", description = "This API will save the product")
    @PostMapping
    public ResponseEntity<Product> createProduct(Product product){
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all products", description = "This API will fetch all the products available")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Gets a product by id", description = "This API will fetch a product using id")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(summary = "Updates a product", description = "This API will update the product and its attributes")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody ProductRequest productRequest){
        productService.updateProduct(id, productRequest);
        return ResponseEntity.ok("Product updated successfully");
    }

    @Operation(summary = "Deletes a product", description = "This API will delete a product by the given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    //Naming Convention

    @Operation(summary = "Gets products with cost more than the given minimum price")
    @GetMapping("/priceGreaterThan/{minPrice}")
    public List<Product> getProductsCostingMoreThan(@PathVariable double minPrice) {
        return productService.getProductsCostingMoreThan(minPrice);
    }

    @Operation(summary = "Gets a product in the requested category and price less than the given maximum price")
    @GetMapping("/categoryAndPriceLessThan")
    public List<Product> getProductsInCategoryAndPriceLessThan(@RequestParam long categoryId, @RequestParam double maxPrice) {
        return productService.getProductsInCategoryAndPriceLessThan(categoryId, maxPrice);
    }

    @Operation(summary = "Gets a product containing the given keyword")
    @GetMapping("/nameContaining")
    public List<Product> getProductsContainingKeyword(@RequestParam String keyword) {
        return productService.getProductsContainingKeyword(keyword);
    }


}
