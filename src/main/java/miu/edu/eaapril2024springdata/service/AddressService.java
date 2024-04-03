package miu.edu.eaapril2024springdata.service;

import miu.edu.eaapril2024springdata.entity.Address;

import java.util.List;

public interface AddressService {

    Address getById(Long id);
    List<Address> getAll();
    void add(Address address);
    void update(Long id, Address address);
    void delete(Long id);

}
