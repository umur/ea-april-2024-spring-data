package com.brianmugalu.demo.repository.dto;

import com.brianmugalu.demo.repository.entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address,Long> {
}
