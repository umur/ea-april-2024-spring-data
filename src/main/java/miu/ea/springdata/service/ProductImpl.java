package miu.ea.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Product;
import miu.ea.springdata.repository.AddressRepository;
import miu.ea.springdata.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            Product existedProduct = optionalProduct.get();

            existedProduct.setName(product.getName());
            existedProduct.setPrice(product.getPrice());
            existedProduct.setRating(product.getRating());
            existedProduct.setCategory(product.getCategory());
            existedProduct.setReviewList(product.getReviewList());

            return productRepository.save(existedProduct);
        } else {
            // Handle the case where the address with the given ID does not exist
            throw new RuntimeException("Product with ID " + product.getId() + " not found");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProdutsGreaterThanPrice(double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductsByCategoryNameAndPriceLessThan(String name, double maxPrice) {
        return productRepository.findByCategoryNameAndPriceLessThan(name, maxPrice);
    }

    @Override
    public List<Product> getProductByKeywordInName(String keyword) {
        return productRepository.findAllByNameContainsIgnoreCase(keyword);
    }
}
