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

    @PostMapping("/{id}")
    public Address addAddress(@RequestBody Address address, @PathVariable(name = "id") Long userId){
        return addressService.addAddress(address,userId);
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Long id){
        return  addressService.getAddress(id);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return "Deleted Successfully";
    }

}
