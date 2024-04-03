package miu.edu.eaapril2024springdata.repository;

import miu.edu.eaapril2024springdata.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AddressRepository extends ListCrudRepository<Address, Long> {

    Address getById(Long id);

}
