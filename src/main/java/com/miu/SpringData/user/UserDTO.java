package com.miu.SpringData.user;

import com.miu.SpringData.address.AddressDTO;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private AddressDTO address;
}
