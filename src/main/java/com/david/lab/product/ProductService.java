package com.david.lab.product;

import com.david.lab.category.Category;
import com.david.lab.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> findAllByPriceGreaterThan(BigDecimal minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice);
    }

    public List<Product> findAllByPriceLessThanAndCategoryIs(BigDecimal maxPrice, long categoryId) {
        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id " + categoryId));
        return productRepository.findAllByPriceLessThanAndCategoryIs(maxPrice, category);
    }

    public List<Product> findByNameContaining(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}