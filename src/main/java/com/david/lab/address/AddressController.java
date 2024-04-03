package com.david.lab.address;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Address APIs", description = "APIs for managing addresses")
@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @Operation(summary = "Create a new address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @GetMapping("{id}")
    @Operation(summary = "Get an address by Id")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        return addressService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Operation(summary = "Update an existing address")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.update(address));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete an address by Id")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}