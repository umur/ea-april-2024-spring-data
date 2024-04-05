package springData.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springData.example.demo.Service.ProductService;
import springData.example.demo.domain.Product;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductContoller {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
       productService.createProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id){
       productService.deleteProductById(id);
    }


    @GetMapping("/min/{price}")
    public List<Product> findAllByPriceGreaterThan(@PathVariable double price){
        return productService.findAllByPriceGreaterThan(price);
    }

    @GetMapping("/category")
    List<Product>  findAllByCategoryContainingAndPriceGreaterThan(@RequestParam String cat, @RequestParam double price ){
        return productService.findAllByCategoryContainingAndPriceGreaterThan(cat,price);
    }

@GetMapping("/name/{key}")
    public  List<Product> findAllByNameContains(@PathVariable String key){
        return productService.findAllByNameContains(key);
    }
}

