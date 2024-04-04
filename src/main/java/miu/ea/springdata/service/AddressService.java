package miu.ea.springdata.service;

import miu.ea.springdata.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address addAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddress(Long id);
}
