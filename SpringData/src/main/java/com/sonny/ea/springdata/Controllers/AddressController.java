package com.sonny.ea.springdata.Controllers;

import com.sonny.ea.springdata.Entities.Address;
import com.sonny.ea.springdata.Services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/{id}")
    Address getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @PostMapping
    void addAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    void updateAddress(@PathVariable Long id, @RequestBody Address address) {
        addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
