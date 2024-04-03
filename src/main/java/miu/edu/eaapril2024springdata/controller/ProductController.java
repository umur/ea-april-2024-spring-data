package miu.edu.eaapril2024springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.Category;
import miu.edu.eaapril2024springdata.entity.Product;
import miu.edu.eaapril2024springdata.service.AddressService;
import miu.edu.eaapril2024springdata.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Product product) {
        productService.update(id, product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("filter-by-cost")
    public List<Product> filterByCost(@RequestParam double cost) {
        return productService.filterByCost(cost);
    }

    @GetMapping("filter-by-category-and-price")
    public List<Product> filterByCategoryAndPrice(@RequestBody Category category,
                                                  @RequestParam double maxPrice) {
        return productService.filterByCategoryAndPrice(category, maxPrice);
    }

    @GetMapping("filter-by-keyword")
    public List<Product> filterByKeyword(@RequestParam String keyword) {
        return productService.filterByKeyword(keyword);
    }

}
