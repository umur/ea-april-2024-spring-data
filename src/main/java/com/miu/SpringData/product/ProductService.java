package com.miu.SpringData.product;

import com.miu.SpringData.category.Category;
import com.miu.SpringData.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .toList();
    }

    public String newProduct(ProductDTO productDTO) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());

        Category category = categoryRepository.findById(productDTO.getCategory().getId()).orElse(new Category());
        product.setCategory(category);

        productRepository.save(product);

        return "Successfully added.";
    }

    public String updateProduct(ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());

        Category category = categoryRepository.findById(productDTO.getCategory().getId()).orElse(new Category());
        product.setCategory(category);

        productRepository.save(product);

        return "Successfully updated.";
    }

    public String deleteProduct(ProductDTO productDTO) {
        productRepository.deleteById(productDTO.getId());
        return "Successfully deleted.";
    }

    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public List<Product> getMinPrice(double minPrice) {

        return productRepository.findByPriceGreaterThan(minPrice);
    }

    public List<Product> getMaxPrice(long cat, double maxPrice) {
        Category category = categoryRepository.findById(cat).orElse(new Category());

        return productRepository.findByCategoryAndPriceLessThan(category, maxPrice);
    }

    public List<Product> findByNameContains(String searchName) {
        return productRepository.findByNameContaining(searchName);
    }
}
