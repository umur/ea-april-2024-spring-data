package edu.miu.springdata.service;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public boolean update(long id, Product product) {
        if(productRepo.findById(id).isPresent()){
            Product prod = productRepo.findById(id).get();
            prod.setCategory(product.getCategory());
            prod.setName(product.getName());
            prod.setRating(prod.getRating());
            prod.setPrice(prod.getPrice());

            productRepo.save(prod);
            return true;

        }
        else{
            return false;
        }
    }

    @Override
    public void deleteById(long id) {
        productRepo.deleteById(id);

    }

    @Override
    public List<Product> getProductGreaterThanPrice(double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getProductByCategoryAndPrice(Long cat, double price) {
        return productRepo.findAllByCategoryIdAndPriceGreaterThan(cat, price);
    }

    @Override
    public List<Product> getProductsByNameLike(String keyword) {
        return productRepo.getProductsByNameLike(keyword);
    }
}
