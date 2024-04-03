package miu.edu.eaapril2024springdata.service;

import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.Category;

import java.util.List;

public interface CategoryService {
    Category getById(Long id);
    List<Category> getAll();
    void add(Category category);
    void update(Long id, Category category);
    void delete(Long id);
}
