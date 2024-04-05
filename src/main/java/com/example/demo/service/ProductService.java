package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if(existProduct == null) return null;
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setRating(product.getRating());
        return productRepository.save(existProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByMinPrice(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    public List<Product> getProductsByCategoryNameAndMaxPrice(String categoryName, Double maxPrice) {
        return productRepository.findByCategoryNameAndPriceLessThan(categoryName, maxPrice);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
