package miu.ea.lab3.service;

import miu.ea.lab3.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    Address save(Address address);
    Address update(Address address);
    void delete(Long id);
    List<Address> getAll();
}
