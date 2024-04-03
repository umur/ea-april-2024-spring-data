package com.sonny.ea.springdata.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    private Long id;
    private String comment;
}
