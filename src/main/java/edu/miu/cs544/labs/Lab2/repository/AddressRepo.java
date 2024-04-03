package edu.miu.cs544.labs.Lab2.repository;

import edu.miu.cs544.labs.Lab2.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepo extends ListCrudRepository<Address, Long> {
}
