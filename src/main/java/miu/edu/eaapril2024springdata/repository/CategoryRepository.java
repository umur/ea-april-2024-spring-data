package miu.edu.eaapril2024springdata.repository;

import miu.edu.eaapril2024springdata.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {

    Category getById(Long id);

}
