package com.example.eaapril2024springdata.reponsitory;

import com.example.eaapril2024springdata.model.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends ListCrudRepository<Category,Long> {
}
