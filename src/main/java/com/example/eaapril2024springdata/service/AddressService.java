package com.example.eaapril2024springdata.service;

import com.example.eaapril2024springdata.model.Address;
import com.example.eaapril2024springdata.reponsitory.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    Address create(Address address);

    Address save(Address address);

    Address update(Long id, Address address);

    void deleteById(Long id);

    List<Address> findAll();
}
