package com.example.eaapril2024springdata.reponsitory;

import com.example.eaapril2024springdata.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User,Long> {
}
