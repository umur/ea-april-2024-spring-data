package com.brianmugalu.demo.controller;

import com.brianmugalu.demo.repository.entity.Address;
import com.brianmugalu.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Long id){
        return  addressService.getAddress(id);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id){
        return addressService.updateAddress(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return "Deleted Successfully";
    }

}
