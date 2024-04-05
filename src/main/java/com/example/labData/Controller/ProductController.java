package com.example.labData.Controller;

import com.example.labData.Entity.Category;
import com.example.labData.Entity.Product;
import com.example.labData.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    public List<Product> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Product product) {
        service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Product product) {
        service.update(product);
    }

    @GetMapping("/getByPriceGreaterThan")
    public List<Product> findAllByPriceGreaterThan(double minPrice){
        return service.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/getByCategoryAndPriceLessThan")
    public List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice){
        return service.findAllByCategoryAndPriceLessThan(cat, maxPrice);
    }

    @GetMapping("/getByNameContains")
    public List<Product> findAllByNameContains(String keyword){
        return service.findAllByNameContains(keyword);
    }
}
