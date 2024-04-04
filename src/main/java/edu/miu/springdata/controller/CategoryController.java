package edu.miu.springdata.controller;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        categoryService.deleteById(id);
    }



}
