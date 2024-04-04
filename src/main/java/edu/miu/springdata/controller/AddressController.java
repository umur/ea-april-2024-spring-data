package edu.miu.springdata.controller;

import edu.miu.springdata.entity.Address;
import edu.miu.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/address")
@RestController
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable long id){
        return addressService.getAddress(id);
    }

    @PutMapping("/{id}")
    public boolean updateAddress(@PathVariable long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable long id){
        addressService.deleteAddress(id);
    }
}
