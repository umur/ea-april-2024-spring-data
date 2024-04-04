package miu.ea.springdata.repository;

import miu.ea.springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findByProductId(Long id);
}
