package miu.ea.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Category;
import miu.ea.springdata.service.AddressService;
import miu.ea.springdata.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    //CRUD of Category
    //Get all address
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> result = categoryService.getAllCategory();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Create Address
    @PostMapping
    public ResponseEntity<Category> addAddress(@RequestBody Category category){
        Category result = categoryService.addCategory(category);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Update Address
    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category result = categoryService.updateCategory(category);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Delete Address
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "Delete Successfully ";
    }
}
