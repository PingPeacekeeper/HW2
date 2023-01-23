package com.example.hw2.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code, String msg) {
        super(msg);
        this.code = code;
    }


}
