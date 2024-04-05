package sean.ea.labs.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sean.ea.labs.lab3.entity.Category;
import sean.ea.labs.lab3.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(value = "select p.name from Product p")
    List<IProductName> findAllName();

    List<Product> findAllByPriceIsGreaterThan(BigDecimal minPrice);
    List<Product> findAllByCategory_IdAndPriceIsLessThan(Long catId, BigDecimal maxPrice);
    List<Product> findAllByNameContaining(String name);
}
