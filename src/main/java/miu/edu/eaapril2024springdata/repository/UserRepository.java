package miu.edu.eaapril2024springdata.repository;

import miu.edu.eaapril2024springdata.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {

    User getById(Long id);

}
