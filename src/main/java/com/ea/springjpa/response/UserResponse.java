package com.ea.springjpa.response;


import com.ea.springjpa.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserResponse {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private AddressResponse addressResponse;



    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        if (user.getAddress() != null) {
            this.addressResponse = new AddressResponse(user.getAddress());
        }
    }
}
