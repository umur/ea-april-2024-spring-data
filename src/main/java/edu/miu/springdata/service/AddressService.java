package edu.miu.springdata.service;

import edu.miu.springdata.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    Address getAddress(long id);
    boolean updateAddress(long id, Address address);
    void deleteAddress(long id);
}
