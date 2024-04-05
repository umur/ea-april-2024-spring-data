package com.brianmugalu.demo.service;

import com.brianmugalu.demo.repository.dto.AddressRepo;
import com.brianmugalu.demo.repository.dto.UserRepo;
import com.brianmugalu.demo.repository.entity.Address;
import com.brianmugalu.demo.repository.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.ErrorManager;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;
    private final UserRepo userRepo;

    @Transactional
    public Address addAddress(Address address, Long userId) {
       User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("Address with id " + userId + " not found"));
        user.setAddress(address);
        address.setUser(user);
        return address;
    }

    public Address getAddress(Long id) {
        return  addressRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Address with id " + id + " not found"));

    }
    @Transactional
    public Address updateAddress(Long id, Address address) {
        Address add = addressRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Address with id " + id + " not found"));;
        add.setUser(address.getUser());
        add.setStreet(address.getStreet());
        add.setZip(address.getZip());
        add.setCity(address.getCity());
        return add;
    }

    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }
}
