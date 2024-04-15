package com.ea.springjpa.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressRequest {

    private String street;

    private String zip;

    private String city;

}