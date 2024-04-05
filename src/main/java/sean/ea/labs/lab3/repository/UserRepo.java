package sean.ea.labs.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sean.ea.labs.lab3.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
