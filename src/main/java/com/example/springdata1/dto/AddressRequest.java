package com.example.springdata1.dto;

import lombok.Data;

@Data
public class AddressRequest {
    private long id;
    private String street;
    private String zip;
    private String city;
}
