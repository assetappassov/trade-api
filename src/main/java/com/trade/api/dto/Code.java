package com.trade.api.dto;

public enum Code {

    SUCCESS(200),
    ERROR_VALIDATION(400);

    private int code;

    Code(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
