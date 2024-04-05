package com.example.labData.Controller;

import com.example.labData.Entity.Address;
import com.example.labData.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;
    @GetMapping("/")
    public List<Address> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Address address) {
        service.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Address address) {
        service.update(address);
    }
}
