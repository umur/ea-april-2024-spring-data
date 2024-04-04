package edu.miu.springdata.service;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.repository.ProductRepo;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product save(Product product);

    public boolean update(long id, Product product);

    public void deleteById(long id);

    List<Product> getProductGreaterThanPrice(double price);

    List<Product> getProductByCategoryAndPrice(Long cat, double price);
}
