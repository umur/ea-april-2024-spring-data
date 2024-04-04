package miu.ea.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Category;
import miu.ea.springdata.entity.Product;
import miu.ea.springdata.service.CategoryService;
import miu.ea.springdata.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    //CRUD of Product
    //Get all address
    @GetMapping
    public ResponseEntity<List<Product>> getAllCategories(){
        List<Product> result = productService.getAllProduct();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Create Address
    @PostMapping
    public ResponseEntity<Product> addAddress(@RequestBody Product product){
        Product result = productService.addProduct(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Update Address
    @PutMapping
    public ResponseEntity<Product> updateCategory(@RequestBody Product product){
        Product result = productService.updateProduct(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Delete Address
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Delete Successfully ";
    }

    //Find all products that cost more than minPrice.
    @GetMapping("/product-by-minprice")
    public ResponseEntity<List<Product>> getAllProductsGreaterThanPrice(@RequestParam double price){
        List<Product> result = productService.getProdutsGreaterThanPrice(price);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Find all products in cat category and cost less than maxPrice.
    @GetMapping("/product-by-categoryname-and-price-lessthan")
    public ResponseEntity<List<Product>> getAllProductsByCategoryAndPrice(@RequestParam String name, @RequestParam double price){
        List<Product> result = productService.getProductsByCategoryNameAndPriceLessThan(name, price);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Find all products that contain keyword in the name.
    @GetMapping("/find-by-keyword/{keyword}")
    public ResponseEntity<List<Product>> getAllProductsByContainKeyword(@PathVariable String keyword){
        List<Product> result = productService.getProductByKeywordInName(keyword);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
