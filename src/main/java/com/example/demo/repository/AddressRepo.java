package com.example.demo.repository;

import com.example.demo.enity.Address;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends ListCrudRepository<Address, Long> {
//    @Query(name = "SELECT a FROM address a WHERE a.street = ?1 and ?2", nativeQuery = true)
//    List<Address> getList(String street, int price);
}
