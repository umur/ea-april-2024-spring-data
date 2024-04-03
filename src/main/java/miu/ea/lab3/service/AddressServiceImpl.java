package miu.ea.lab3.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Address;
import miu.ea.lab3.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        Address existingAddress = addressRepository.findById(address.getId()).orElseThrow(
                () -> new RuntimeException("Address does not exist: " + address.getId())
        );
        existingAddress.setCity(address.getCity());
        existingAddress.setZip(address.getZip());
        existingAddress.setStreet(address.getStreet());
        addressRepository.save(existingAddress);
        return existingAddress;
    }

    @Override
    public void delete(Long id) {
        Address existingAddress = addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address does not exist: " + id)
        );
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
