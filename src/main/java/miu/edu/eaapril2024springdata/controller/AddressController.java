package miu.edu.eaapril2024springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("{id}")
    public Address getById(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Address address) {
        addressService.add(address);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Address address) {
        addressService.update(id, address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

}
