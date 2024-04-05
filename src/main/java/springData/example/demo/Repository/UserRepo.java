package springData.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springData.example.demo.domain.Address;
import springData.example.demo.domain.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
