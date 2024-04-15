package com.ea.springjpa.service;

import com.ea.springjpa.entity.Category;
import com.ea.springjpa.entity.Product;
import com.ea.springjpa.repository.CategoryRepository;
import com.ea.springjpa.repository.ProductRepository;
import com.ea.springjpa.request.ProductRequest;
import com.ea.springjpa.response.ProductResponse;
import com.ea.springjpa.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;



    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setRating(productRequest.getRating());
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow();
        product.setCategory(category);
        productRepository.save(product);
        return new ProductResponse(product);
    }



    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new).toList();
    }



    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return new ProductResponse(product);
    }



    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setRating(productRequest.getRating());
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow();
        product.setCategory(category);
        productRepository.save(product);
        return new ProductResponse(product);
    }



    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }



    public List<ProductResponse> getProductsGreaterThanMinPrice(BigDecimal minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice).stream()
                .map(ProductResponse::new).toList();
    }



    public List<ProductResponse> getProductsLessThanMaxPrice(Long categoryId, BigDecimal maxPrice) {
        return productRepository.findByCategoryIdAndPriceLessThan(categoryId, maxPrice).stream()
                .map(ProductResponse::new).toList();
    }



    public List<ProductResponse> searchProducts(String keyword) {
        return productRepository.findByNameContaining(keyword).stream()
                .map(ProductResponse::new).toList();
    }



    public List<ReviewResponse> getReviews(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return product.getReviews().stream()
                .map(ReviewResponse::new).toList();
    }
}
