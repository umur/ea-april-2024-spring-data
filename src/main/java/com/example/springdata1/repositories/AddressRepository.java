package com.example.springdata1.repositories;

import com.example.springdata1.domain.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Long> {
}
