package com.example.springdata1.controller;

import com.example.springdata1.domain.Address;
import com.example.springdata1.dto.AddressRequest;
import com.example.springdata1.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @Operation(summary = "Saves an address", description = "This API will save the address")
    @PostMapping
    public ResponseEntity<Address> createAddress(Address address){
        Address savedAddress = addressService.createAddress(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all addresses", description = "This API will fetch all the addresses available")
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @Operation(summary = "Gets an Address by id", description = "This API will fetch an address using id")
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @Operation(summary = "Updates an address", description = "This API will update the address and its attributes")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable long id, @RequestBody AddressRequest addressRequest){
        addressService.updateAddress(id, addressRequest);
        return ResponseEntity.ok("Address updated successfully");
    }

    @Operation(summary = "Deletes an address", description = "This API will delete an address by the given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable long id){
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("Address deleted successfully");
    }


}
