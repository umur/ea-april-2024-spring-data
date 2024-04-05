package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Category;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if(address == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found!");
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        if (updatedAddress == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update address!");
        }
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }
}
