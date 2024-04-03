package miu.ea.lab3.service;

import miu.ea.lab3.model.Category;
import miu.ea.lab3.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product update(Product product);
    void delete(Long id);
    List<Product> getAll();
    List<Product> getProductsGreaterThanPrice(double price);
    List<Product> getProductsContainKeyword(String keyword);
    List<Product> getProductsByCategoryAndPrice(List<Category> cats, double maxPrice);
}
