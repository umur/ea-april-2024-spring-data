package springData.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springData.example.demo.Repository.ProductRepo;
import springData.example.demo.domain.Product;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }
    public Optional<Product> getProductById(Long id){
        return productRepo.findById(id);
    }
    public void createProduct(Product product){
        productRepo.save(product);
    }
    public void updateProduct(Product product){
        productRepo.save(product);
    }
    public void deleteProductById(long id){
        productRepo.deleteById(id);
    }

    public List<Product> findAllByPriceGreaterThan(double price){
        return productRepo.findAllByPriceGreaterThan(price);
    }
    public List<Product>  findAllByCategoryContainingAndPriceGreaterThan(String cat, double price ){
        return productRepo.findAllByCategory_NameAndPriceGreaterThan(cat,price);
    }
    public  List<Product> findAllByNameContains(String key){
        return productRepo.findAllByNameContains(key);
    }
}
