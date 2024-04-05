package springData.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springData.example.demo.domain.Address;
import springData.example.demo.domain.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
