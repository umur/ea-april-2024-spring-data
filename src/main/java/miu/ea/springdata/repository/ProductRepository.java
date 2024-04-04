package miu.ea.springdata.repository;

import miu.ea.springdata.entity.Category;
import miu.ea.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByPriceGreaterThan(double minPrice);

//    Find all products in cat category and cost less than maxPrice.
    List<Product> findByCategoryNameAndPriceLessThan(String name, double maxPrice);

    //Find all products that contain keyword in the name.

    List<Product> findAllByNameContainsIgnoreCase(String keyword);
}
