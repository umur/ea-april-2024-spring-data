package com.miu.SpringData.address;

import lombok.Data;

@Data
public class AddressDTO {
    private long id;
    private String street;
    private String city;
    private String zip;
}
