package edu.miu.springdata.repository;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {

    public List<Product> findAllByPriceGreaterThan(double price);

    public List<Product> findAllByCategoryIdAndPriceGreaterThan(Long category, double price);
    @Query("select e from #{#entityName} e where e.name LIKE %:keyword%")
    List<Product> getProductsByNameLike(String keyword);
}
