package edu.miu.springdata.controller;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return  productService.findAll();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id, @RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        productService.deleteById(id);
    }

    @GetMapping("/{price}")
    public List<Product> getProductsGreaterThanPrice(@PathVariable double price){
        return productService.getProductGreaterThanPrice(price);
    }

    @GetMapping("/filter")
    public List<Product> getProductsByCatAndPrice(@RequestParam(name = "cat") Long cat, @RequestParam double price){
        return productService.getProductByCategoryAndPrice(cat, price);
    }

}
