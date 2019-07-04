package com.trade.api.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ResponseInfo {
    private int code;
    private UUID id;
    private List<TradeError> errors;

    public void setCode(Code code) {
        this.code = code.getCode();
    }
}
