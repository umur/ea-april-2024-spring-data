package miu.ea.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    //CRUD of Address
    //Get all address
    @GetMapping
    public ResponseEntity<List<Address>> getAllAdresses(){
        List<Address> result = addressService.getAllAddress();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Create Address
    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address result = addressService.addAddress(address);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Update Address
    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        Address result = addressService.updateAddress(address);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Delete Address
    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return "Delete Successfully ";
    }
}
