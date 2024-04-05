package com.miu.SpringData.address;

import com.miu.SpringData.category.Category;
import com.miu.SpringData.category.CategoryDTO;
import org.hibernate.annotations.Parameter;
import org.hibernate.mapping.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Address>> index() {

        return ResponseEntity.ok(this.addressService.getAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> index(@PathVariable Long id) {

        return ResponseEntity.ok(this.addressService.getAddress(id).orElse(new Address()));
    }

    @PostMapping("/new")
    public ResponseEntity<String> newAddress(@RequestBody AddressDTO addressDTO) {

        return ResponseEntity.ok(this.addressService.newAddress(addressDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddress(@RequestBody AddressDTO addressDTO) {

        return ResponseEntity.ok(this.addressService.updateAddress(addressDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestBody AddressDTO addressDTO) {

        return ResponseEntity.ok(this.addressService.deleteAddress(addressDTO));
    }
}
