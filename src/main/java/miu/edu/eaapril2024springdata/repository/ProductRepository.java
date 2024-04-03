package miu.edu.eaapril2024springdata.repository;

import miu.edu.eaapril2024springdata.entity.Category;
import miu.edu.eaapril2024springdata.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

    public Product getById(Long id);

    List<Product> getAllByPriceGreaterThan(double cost);

    List<Product> getAllByCategoryIsAndPriceIsLessThan(Category category, double maxPrice);

    List<Product> getAllByNameContains(String keyword);
}
