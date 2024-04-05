package springData.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springData.example.demo.Service.AddressService;
import springData.example.demo.domain.Address;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public void createAddress(@RequestBody Address address){
       addressService.createAddress(address);
    }

    @PutMapping
    public void updateAddress(@RequestBody Address address){
       addressService.updateAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable long id){
        addressService.deleteAddressById(id);
    }
}
