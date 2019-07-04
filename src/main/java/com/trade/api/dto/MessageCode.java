package com.trade.api.dto;

public enum MessageCode {
    VALUE_DATE("valueDate"),
    PAY_CCY("payCcy"),
    PREMIUM_CCY("premiumCcy"),
    EXCERCISE_START_DATE("excerciseStartDate"),
    EXPIRE_DATE("expiryDate"),
    LEGAL_ENTITY("legalEntity"),
    CUSTOMER("customer"),
    PREMIUM_DATE("premiumDate");

    private String code;

    MessageCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
