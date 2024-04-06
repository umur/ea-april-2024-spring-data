package com.example.springdata1.services;

import com.example.springdata1.domain.Category;
import com.example.springdata1.domain.Product;
import com.example.springdata1.dto.ProductRequest;
import com.example.springdata1.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        return productRepository.findById(id).get();
    }

    public Product updateProduct(long id, ProductRequest productRequest){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct != null){
            existingProduct.setName(productRequest.getName());
            existingProduct.setPrice(productRequest.getPrice());
            existingProduct.setRating(productRequest.getRating());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProductById(long id){
        productRepository.deleteById(id);
    }


    public List<Product> getProductsCostingMoreThan(double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }


    public List<Product> getProductsInCategoryAndPriceLessThan(long categoryId, double maxPrice) {
        Category category = categoryService.getCategoryById(categoryId);
        return productRepository.findByCategoryAndPriceLessThan(category, maxPrice);
    }


    public List<Product> getProductsContainingKeyword(String keyword) {
        return productRepository.findProductByNameContaining(keyword);
    }

}
