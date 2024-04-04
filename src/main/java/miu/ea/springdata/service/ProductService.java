package miu.ea.springdata.service;

import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getProdutsGreaterThanPrice(double minPrice);

    List<Product> getProductsByCategoryNameAndPriceLessThan(String name, double maxPrice);

    List<Product> getProductByKeywordInName(String keyword);
}
