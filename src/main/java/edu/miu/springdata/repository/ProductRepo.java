package edu.miu.springdata.repository;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {

    public List<Product> findAllByPriceGreaterThan(double price);

    public List<Product> findAllByCategoryIdAndPriceGreaterThan(Long category, double price);
}
