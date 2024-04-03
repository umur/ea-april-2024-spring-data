package miu.ea.lab3.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Address;
import miu.ea.lab3.model.Category;
import miu.ea.lab3.model.Product;
import miu.ea.lab3.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElseThrow(
                () -> new RuntimeException("Product does not exist: " + product.getId())
        );
        existingProduct.setName(product.getName());
        existingProduct.setRating(product.getRating());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsGreaterThanPrice(double price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getProductsContainKeyword(String keyword) {
        return productRepository.findByNameContains(keyword);
    }

    @Override
    public List<Product> getProductsByCategoryAndPrice(List<Category> cats, double maxPrice) {
        return productRepository.findByCategoryInAndPriceLessThan(cats, maxPrice);
    }
}
