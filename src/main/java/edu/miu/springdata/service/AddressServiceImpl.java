package edu.miu.springdata.service;

import edu.miu.springdata.entity.Address;
import edu.miu.springdata.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    @Override
    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    @Override
    public Address getAddress(long id) {
        return addressRepo.findById(id).orElse(null);
    }

    @Override
    public boolean updateAddress(long id, Address address) {
        Address optionalAddress = addressRepo.findById(id).orElse(null);

        if(optionalAddress == null){
            return false;
        }

        optionalAddress.setCity(address.getCity());
        optionalAddress.setZip(address.getZip());
        optionalAddress.setStreet(address.getStreet());

        addressRepo.save(optionalAddress);
        return true;
    }

    @Override
    public void deleteAddress(long id) {
        addressRepo.deleteById(id);
    }
}
