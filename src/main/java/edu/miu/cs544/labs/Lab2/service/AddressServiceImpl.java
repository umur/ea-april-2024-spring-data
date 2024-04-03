package edu.miu.cs544.labs.Lab2.service;

import edu.miu.cs544.labs.Lab2.entity.Address;
import edu.miu.cs544.labs.Lab2.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    @Override
    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepo.findById(id);
    }

    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public void update(Address address) {
        addressRepo.save(address);
    }
}
