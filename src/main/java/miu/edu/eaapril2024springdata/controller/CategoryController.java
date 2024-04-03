package miu.edu.eaapril2024springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.Category;
import miu.edu.eaapril2024springdata.service.AddressService;
import miu.edu.eaapril2024springdata.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Category category) {
        categoryService.add(category);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Category category) {
        categoryService.update(id, category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
