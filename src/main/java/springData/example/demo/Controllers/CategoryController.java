package springData.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springData.example.demo.Service.CategoryService;
import springData.example.demo.domain.Category;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable long id){
       categoryService.deleteCategoryById(id);
    }
}
