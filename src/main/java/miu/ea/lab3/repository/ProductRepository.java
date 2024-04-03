package miu.ea.lab3.repository;

import miu.ea.lab3.model.Category;
import miu.ea.lab3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(double price);
    List<Product> findByNameContains(String keyword);
    List<Product> findByCategoryInAndPriceLessThan(List<Category> cats, double maxPrice);
}
