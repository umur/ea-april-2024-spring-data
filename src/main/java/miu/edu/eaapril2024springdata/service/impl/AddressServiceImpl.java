package miu.edu.eaapril2024springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.repository.AddressRepository;
import miu.edu.eaapril2024springdata.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address getById(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void add(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void update(Long id, Address address) {
        Address a = addressRepository.getById(id);
        a.setCity(address.getCity());
        a.setZip(address.getZip());
        a.setStreet(address.getStreet());
        addressRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
