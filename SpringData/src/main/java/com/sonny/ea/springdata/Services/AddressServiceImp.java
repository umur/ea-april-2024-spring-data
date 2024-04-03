package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Address;
import com.sonny.ea.springdata.Repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Address not found"));
    }

    @Override
    public void updateAddress(Long id, Address address) {
        Address exist = addressRepository.findById(id).orElse(null);
        if (exist != null) {
            if (!address.getCity().isEmpty()) exist.setCity(address.getCity());
            if(!address.getZip().isEmpty()) exist.setZip(address.getZip());
            if(!address.getStreet().isEmpty()) exist.setStreet(address.getStreet());

            addressRepository.save(exist);
        }
    }

    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        //find user to remove address

        addressRepository.deleteById(id);
    }
}
