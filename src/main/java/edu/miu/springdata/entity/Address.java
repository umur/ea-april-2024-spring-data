package edu.miu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private long id;
    private String street;
    private int zip;
    private String City;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private User user;
}
