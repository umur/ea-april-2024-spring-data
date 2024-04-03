package miu.ea.lab3.service;

import miu.ea.lab3.model.Category;
import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category update(Category category);
    void delete(Long id);
    List<Category> getAll();
}
