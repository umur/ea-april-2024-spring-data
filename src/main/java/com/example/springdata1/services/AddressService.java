package com.example.springdata1.services;

import com.example.springdata1.domain.Address;
import com.example.springdata1.dto.AddressRequest;
import com.example.springdata1.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;


    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public Address getAddressById(long id){
        return addressRepository.findById(id).get();
    }

    public Address updateAddress(long id, AddressRequest addressRequest){
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if(existingAddress != null){
            existingAddress.setStreet(addressRequest.getStreet());
            existingAddress.setZip(addressRequest.getZip());
            existingAddress.setCity(addressRequest.getCity());
            return addressRepository.save(existingAddress);
        }
        return null;
    }

    public void deleteAddressById(long id){
        addressRepository.deleteById(id);
    }

}
