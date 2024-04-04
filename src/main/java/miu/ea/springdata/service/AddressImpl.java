package miu.ea.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressImpl implements AddressService{

    private final AddressRepository addressRepository;


    @Override
    public List<Address> getAllAddress() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(address.getId());
        if(optionalAddress.isPresent()){
            Address existedAddress = optionalAddress.get();

            existedAddress.setCity(address.getCity());
            existedAddress.setZip(address.getZip());
            existedAddress.setStreet(address.getStreet());
            return addressRepository.save(existedAddress);
        } else {
            // Handle the case where the address with the given ID does not exist
            throw new RuntimeException("Address with ID " + address.getId() + " not found");
        }
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
