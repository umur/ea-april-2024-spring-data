package sean.ea.labs.lab3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.ea.labs.lab3.dto.ProductDto;
import sean.ea.labs.lab3.entity.Product;
import sean.ea.labs.lab3.repository.IProductName;
import sean.ea.labs.lab3.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> fetchAll() {
        return productService.getAll();
    }
    @GetMapping("/products/{id}")
    public ProductDto fetchOne(@PathVariable Long id) {
        return productService.get(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") long id, @RequestBody ProductDto productDto) {
        productService.update(id, productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/categories/{categoryId}/products")
    public void creat(@PathVariable Long categoryId, @RequestBody ProductDto productDto) {
        productService.create(categoryId, productDto);
    }

    @GetMapping("/products/priceGreaterThan/{minPrice}")
    public List<ProductDto> findAllByPriceIsGreaterThan(@PathVariable BigDecimal minPrice) {
        return productService.findAllByPriceIsGreaterThan(minPrice);
    }

    @GetMapping("/products/categories/{catId}/priceLessThan/{maxPrice}")
    public List<ProductDto> findAllByCategoryAndPriceIsLessThan(@PathVariable Long catId, @PathVariable BigDecimal maxPrice) {
        return productService.findAllByCategoryAndPriceIsLessThan(catId, maxPrice);
    }

    @GetMapping("/products/nameContaining/{infix}")
    public List<ProductDto> findAllByNameContaining(@PathVariable String infix) {
        return productService.findAllByNameContaining(infix);
    }

}
