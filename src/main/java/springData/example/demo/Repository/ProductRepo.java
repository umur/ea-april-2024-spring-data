package springData.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springData.example.demo.domain.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findAllByPriceGreaterThan(double price);
   List<Product>  findAllByCategory_NameAndPriceGreaterThan(String cat, double price);
   List<Product> findAllByNameContains(String key);
}
