package com.ea.springjpa.response;


import com.ea.springjpa.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressResponse {

    private String street;

    private String zip;

    private String city;



    public AddressResponse(Address address) {
        this.street = address.getStreet();
        this.zip = address.getZip();
        this.city = address.getCity();
    }
}