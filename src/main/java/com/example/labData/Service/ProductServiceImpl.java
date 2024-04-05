package com.example.labData.Service;

import com.example.labData.Entity.Category;
import com.example.labData.Entity.Product;
import com.example.labData.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;

    @Override
    public List<Product> findAll() {
       return repo.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void update(Product product) {
        repo.save(product);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double minPrice) {
        return repo.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice) {
        return repo.findAllByCategoryAndPriceLessThan(cat, maxPrice);
    }

    @Override
    public List<Product> findAllByNameContains(String keyword) {
        return repo.findAllByNameContains(keyword);
    }

}
