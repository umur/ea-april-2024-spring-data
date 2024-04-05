package com.miu.SpringData.product;

import com.miu.SpringData.category.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> index() {

        return ResponseEntity.ok(this.productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getDetails(@PathVariable long id) {
        return ResponseEntity.ok(this.productService.getProduct(id));
    }

    @PostMapping("/new")
    public ResponseEntity<String> newProduct(@RequestBody ProductDTO productDTO) {

        return ResponseEntity.ok(this.productService.newProduct(productDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO) {

        return ResponseEntity.ok(this.productService.updateProduct(productDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody ProductDTO productDTO) {

        return ResponseEntity.ok(this.productService.deleteProduct(productDTO));
    }

    @GetMapping("/min-price")
    public ResponseEntity<List<Product>> minPrice(@RequestParam Double minprice) {

        return ResponseEntity.ok(this.productService.getMinPrice(minprice));
    }

    @GetMapping("/max-price")
    public ResponseEntity<List<Product>> maxPrice(@RequestParam Long cat,@RequestParam Double maxprice) {

        return ResponseEntity.ok(this.productService.getMaxPrice(cat, maxprice));
    }

    @GetMapping("/keyword")
    public ResponseEntity<List<Product>> keyword(@RequestParam String searchName) {

        return ResponseEntity.ok(this.productService.findByNameContains(searchName));
    }

}
