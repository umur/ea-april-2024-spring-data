package com.example.springdata1.repositories;

import com.example.springdata1.domain.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {
}
