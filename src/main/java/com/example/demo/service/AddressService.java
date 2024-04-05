package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Category;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Address existAddress = addressRepository.findById(id).orElse(null);
        if(existAddress == null) return null;
        existAddress.setStreet(address.getStreet());
        existAddress.setCity(address.getCity());
        existAddress.setZip(address.getZip());
        return addressRepository.save(existAddress);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
