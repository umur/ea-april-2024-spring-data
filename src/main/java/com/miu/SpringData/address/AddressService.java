package com.miu.SpringData.address;

import com.miu.SpringData.category.Category;
import com.miu.SpringData.category.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return StreamSupport.stream(addressRepository.findAll().spliterator(), false)
                .toList();

    }

    public Optional<Address> getAddress(Long id) {
        return addressRepository.findById(id);
    }

    public String newAddress(AddressDTO addressDTO) {

        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setZip(addressDTO.getZip());

        addressRepository.save(address);

        return "Successfully added.";
    }

    public String updateAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setZip(addressDTO.getZip());

        addressRepository.save(address);

        return "Successfully updated.";
    }

    public String deleteAddress(AddressDTO addressDTO) {

        addressRepository.deleteById(addressDTO.getId());

        return "Successfully deleted.";
    }
}
