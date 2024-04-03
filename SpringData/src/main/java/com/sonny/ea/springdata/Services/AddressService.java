package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();
    Address getAddress(Long id);

    void updateAddress(Long id, Address address);
    void createAddress(Address address);
    void deleteAddress(Long id);
}
