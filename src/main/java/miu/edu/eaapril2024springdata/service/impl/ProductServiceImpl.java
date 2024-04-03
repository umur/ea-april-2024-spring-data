package miu.edu.eaapril2024springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Category;
import miu.edu.eaapril2024springdata.entity.Product;
import miu.edu.eaapril2024springdata.repository.ProductRepository;
import miu.edu.eaapril2024springdata.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Long id, Product product) {
        Product p = productRepository.getById(id);
        p.setName(product.getName());
        p.setRating(product.getRating());
        p.setPrice(product.getPrice());
        productRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> filterByCost(double cost) {
        return productRepository.getAllByPriceGreaterThan(cost);
    }

    @Override
    public List<Product> filterByCategoryAndPrice(Category category, double maxPrice) {
        return productRepository.getAllByCategoryIsAndPriceIsLessThan(category, maxPrice);
    }

    @Override
    public List<Product> filterByKeyword(String keyword) {
        return productRepository.getAllByNameContains(keyword);
    }
}
