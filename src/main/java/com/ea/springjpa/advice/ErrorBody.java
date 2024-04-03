package com.ea.springjpa.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorBody implements Serializable {

    private String message;
}
