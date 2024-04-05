package com.example.labData.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    private long id;
    private String comment;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
