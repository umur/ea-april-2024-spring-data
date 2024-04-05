package com.example.labData.Service;

import com.example.labData.Entity.Address;
import com.example.labData.Repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo repo;
    @Override
    public List<Address> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Address> findById(long id) {

        return repo.findById(id);
    }

    @Override
    public void save(Address address) {
        repo.save(address);
    }

    @Override
    public void update(Address address) {
        repo.save(address);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
