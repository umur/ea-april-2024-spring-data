package com.ea.springjpa.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryResponse {

    private Long id;

    private String name;



    public CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
