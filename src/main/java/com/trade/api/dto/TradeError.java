package com.trade.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class TradeError {
    private TradeDTO trade;
    private List<MessageDTO> messages;

    public TradeError(TradeDTO trade, List<MessageDTO> messages) {
        this.trade = trade;
        this.messages = messages;
    }
}
