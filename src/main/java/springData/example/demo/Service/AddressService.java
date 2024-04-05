package springData.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springData.example.demo.Repository.AddressRepo;
import springData.example.demo.domain.Address;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public List<Address> getAddress(){
        return addressRepo.findAll();
    }
    public Optional<Address> getAddressById(Long id){
        return addressRepo.findById(id);
    }
    public void createAddress(Address address){
        addressRepo.save(address);
    }
    public void updateAddress(Address address){
        addressRepo.save(address);
    }
    public void deleteAddressById(long id){
        addressRepo.deleteById(id);
    }
}
