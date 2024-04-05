package sean.ea.labs.lab3.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sean.ea.labs.lab3.dto.ProductDto;
import sean.ea.labs.lab3.entity.Category;
import sean.ea.labs.lab3.entity.Product;
import sean.ea.labs.lab3.entity.User;
import sean.ea.labs.lab3.exception.ResourceNotFoundException;
import sean.ea.labs.lab3.repository.CategoryRepo;
import sean.ea.labs.lab3.repository.IProductName;
import sean.ea.labs.lab3.repository.ProductRepo;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public void create(Long categoryId, ProductDto productDto) {
        Category category = categoryRepo.getReferenceById(categoryId);
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .rating(productDto.getRating())
                .category(category)
                .build();
        productRepo.save(product);
    }

    public void update(Long id, ProductDto productDto) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setRating(productDto.getRating());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }

    public ProductDto get(Long id) {
        return productRepo.findById(id).map(this::modelToDto).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(this::modelToDto).toList();
    }

    private ProductDto modelToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<ProductDto> findAllByPriceIsGreaterThan(BigDecimal minPrice) {
        return productRepo.findAllByPriceIsGreaterThan(minPrice).stream().map(this::modelToDto).toList();
    }

    public List<ProductDto> findAllByCategoryAndPriceIsLessThan(Long catId, BigDecimal maxPrice) {
        return productRepo.findAllByCategory_IdAndPriceIsLessThan(catId, maxPrice).stream().map(this::modelToDto).toList();
    }

    public List<ProductDto> findAllByNameContaining(String name) {
        return productRepo.findAllByNameContaining(name).stream().map(this::modelToDto).toList();

    }
}
