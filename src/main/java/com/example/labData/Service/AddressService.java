package com.example.labData.Service;

import com.example.labData.Entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();
    Optional<Address> findById(long id);
    void save(Address address);
    void update(Address address);
    void delete(long id);
}
