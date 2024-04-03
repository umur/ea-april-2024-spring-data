package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Category;
import com.sonny.ea.springdata.Entities.Product;
import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;
    @Override
    public List<Product> getProductsWithMinPrice(Float minPrice) {
        return repository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductsByCategoryWithMaxPrice(Long categoryId, Float maxPrice) {
        Category category = categoryService.getCategory(categoryId);
        return repository.findAllByCategoryEqualsAndPriceLessThan(category,maxPrice);
    }

    @Override
    public List<Product> getProductsContainKeyword(String keyword) {
        return repository.findAllByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Review> getReviewsOfProduct(Long productId) {
        Product product = repository.findById(productId).orElse(null);
        if (product != null) {
            return product.getReviews();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Object not found"));
    }

    @Override
    public void update(Long id, Product newObj) {
        Product exist = repository.findById(id).orElse(null);
        if (exist != null) {
            if (!newObj.getName().isEmpty()) exist.setName(newObj.getName());
            if (newObj.getRating() != null) exist.setRating(newObj.getRating());
            if (newObj.getReviews() != null) exist.setReviews(newObj.getReviews());
            if (newObj.getPrice() != null) exist.setPrice(newObj.getPrice());

            repository.save(exist);
        }
    }

    @Override
    public void add(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Long id) {
        //clear all foreign keys before delete

        repository.deleteById(id);
    }
}
