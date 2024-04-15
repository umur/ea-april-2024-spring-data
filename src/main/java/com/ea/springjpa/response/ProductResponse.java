package com.ea.springjpa.response;


import com.ea.springjpa.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProductResponse {

    private String name;

    private BigDecimal price;

    private int rating;

    private Long categoryId;



    public ProductResponse(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.rating = product.getRating();
        this.categoryId = product.getCategory().getId();
    }
}
