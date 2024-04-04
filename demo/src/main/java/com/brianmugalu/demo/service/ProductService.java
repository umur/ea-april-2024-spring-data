package com.brianmugalu.demo.service;

import com.brianmugalu.demo.repository.dto.CategoryRepo;
import com.brianmugalu.demo.repository.dto.ProductRepo;
import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.repository.entity.Product;
import com.brianmugalu.demo.repository.entity.Review;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryService categoryService;
    public Product addProduct(Product product, Long id) {
        Category category = categoryService.getSingleCategoryById(id);
        category.addProduct(product);
        product.setCategory(category);
        productRepo.save(product);
        return product;
    }

    @Transactional
    public Product updateCategoryName(Long id, String name) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
        product.setName(name);
        productRepo.save(product);
        return product;
    }

    @Transactional
    public Product updateProductPrice(Long id, Double price) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
        product.setPrice(price);
        productRepo.save(product);
        return product;
    }
    @Transactional
    public Product updateProductRating(Long id, Integer rating) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
        product.setRating(rating);
        productRepo.save(product);
        return product;
    }

    public Product getSingleProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getAllProductsByMinPrice(Double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    public List<Product> getAllProductCostLess(String category, Double price) {
        List<Product> productList = productRepo.findAllByCategory(category);
        return productList.stream()
                .filter(product -> product.getPrice()<price)
                .toList();
    }

    public List<Review> getAllReviewsByProductId(Long id) {
        return productRepo.findById(id).get().getReviewList();
    }

    public String deleteProductById(Long id) {
        productRepo.deleteById(id);
        return "Product has been deleted Successfully";
    }

    public List<Product> getAllProductsContaining(String key) {
        return productRepo.findProductByNameContaining(key);
    }
}
