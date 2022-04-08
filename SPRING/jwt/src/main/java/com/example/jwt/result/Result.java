package com.example.jwt.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private boolean success;

    private int code;

    private String message;
}
