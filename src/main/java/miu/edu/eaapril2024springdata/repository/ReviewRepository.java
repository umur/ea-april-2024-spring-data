package miu.edu.eaapril2024springdata.repository;

import miu.edu.eaapril2024springdata.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

public interface ReviewRepository extends ListCrudRepository<Review, Long> {

    Review getById(Long id);

    Review getByProductId(Long id);
}
