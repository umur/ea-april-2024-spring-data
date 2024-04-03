package miu.edu.eaapril2024springdata.service;

import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.Category;
import miu.edu.eaapril2024springdata.entity.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long id);
    List<Product> getAll();
    void add(Product product);
    void update(Long id, Product product);
    void delete(Long id);

    List<Product> filterByCost(double cost);

    List<Product> filterByCategoryAndPrice(Category category, double maxPrice);

    List<Product> filterByKeyword(String keyword);
}
