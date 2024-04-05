package sean.ea.labs.lab3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.ea.labs.lab3.dto.CategoryDto;
import sean.ea.labs.lab3.entity.Category;
import sean.ea.labs.lab3.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> fetchAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> fetchCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryService.create(categoryDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryService.update(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
