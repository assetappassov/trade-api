package com.trade.api.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private String code;
    private String message;

    public MessageDTO(MessageCode code, String message){
        this.code = code.getCode();
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("{code:%s, message:%s}", code, message);
    }
}
