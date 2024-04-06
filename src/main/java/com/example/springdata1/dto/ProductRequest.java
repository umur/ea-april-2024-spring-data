package com.example.springdata1.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private long id;
    private String name;
    private double price;
    private int rating;
}
