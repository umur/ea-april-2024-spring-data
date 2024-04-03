package miu.ea.lab3.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Address;
import miu.ea.lab3.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        Address savedAddress = addressService.save(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        Address updatedAddress = addressService.save(address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity<>("Address successfully deleted.", HttpStatus.OK);
    }
}
