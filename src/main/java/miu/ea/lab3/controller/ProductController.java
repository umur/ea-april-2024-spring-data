package miu.ea.lab3.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Category;
import miu.ea.lab3.model.Product;
import miu.ea.lab3.repository.ProductRepository;
import miu.ea.lab3.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.update(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>("Product successfully deleted.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{price}")
    public ResponseEntity<List<Product>> getProductsGreaterThanPrice(@PathVariable double price) {
        return ResponseEntity.ok(productService.getProductsGreaterThanPrice(price));
    }

    @GetMapping("/name/{keyword}")
    public ResponseEntity<List<Product>> getProductsContainKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(productService.getProductsContainKeyword(keyword));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByCategoryAndPrice(@RequestParam("cat") List<Long> catIds,
                                                                       @RequestParam double maxPrice) {
        List<Category> cats = catIds.stream().map(id -> {
            Category cat = new Category();
            cat.setId(id);
            return cat;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(productService.getProductsByCategoryAndPrice(cats, maxPrice));
    }
}
