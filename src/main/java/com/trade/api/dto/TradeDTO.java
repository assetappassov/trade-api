package com.trade.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TradeDTO implements Serializable {

    private String customer;
    private String ccyPair;
    private Type type;
    private String style;
    private Direction direction;
    private Strategy strategy;
    @ApiModelProperty(example = "2019-07-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date tradeDate;
    private Double amount1;
    private Double amount2;
    @ApiModelProperty(example = "2019-07-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date valueDate;
    private Double rate;
    @ApiModelProperty(example = "2019-07-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deliveryDate;
    @ApiModelProperty(example = "2019-07-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiryDate;
    @ApiModelProperty(example = "2019-07-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date excerciseStartDate;
    private String payCcy;
    private Double premium;
    private String premiumCcy;
    private String premiumType;
    @ApiModelProperty(example = "2019-07-04")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date premiumDate;
    private String legalEntity;
    private String trader;

    public enum Type {
        VanillaOption,
        Spot,
        Forward
    }

    public enum Style {
        AMERICAN,
        EUROPEAN
    }

    public enum Direction {
        SELL,
        BUY
    }

    public enum Strategy {
        CALL
    }

    public enum CCY {
        EUR,
        ALL,
        DZD,
        USD,
        AOA,
        XCD,
        ARS,
        AMD,
        AWG,
        AUD,
        AZN,
        BSD,
        BHD,
        BDT,
        BBD,
        BYR,
        BZD,
        XOF,
        BMD,
        BTN,
        INR,
        BOB,
        BOV,
        BAM,
        BWP,
        NOK,
        BRL,
        BND,
        BGN,
        BIF,
        KHR,
        XAF,
        CAD,
        CVE,
        KYD,
        CLF,
        CLP,
        CNY,
        COP,
        COU,
        KMF,
        CDF,
        NZD,
        CRC,
        HRK,
        CUC,
        CUP,
        ANG,
        CZK,
        DKK,
        DJF,
        DOP,
        EGP,
        SVC,
        ERN,
        ETB,
        FKP,
        FJD,
        XPF,
        GMD,
        GEL,
        GHS,
        GIP,
        GTQ,
        GBP,
        GNF,
        GYD,
        HTG,
        HNL,
        HKD,
        HUF,
        ISK,
        IDR,
        XDR,
        IRR,
        IQD,
        ILS,
        JMD,
        JPY,
        JOD,
        KZT,
        KES,
        KPW,
        KRW,
        KWD,
        KGS,
        LAK,
        LBP,
        LSL,
        ZAR,
        LRD,
        LYD,
        CHF,
        MOP,
        MKD,
        MGA,
        MWK,
        MYR,
        MVR,
        MRO,
        MUR,
        XUA,
        MXN,
        MXV,
        MDL,
        MNT,
        MAD,
        MZN,
        MMK,
        NAD,
        NPR,
        NIO,
        NGN,
        OMR,
        PKR,
        PAB,
        PGK,
        PYG,
        PEN,
        PHP,
        PLN,
        QAR,
        RON,
        RUB,
        RWF,
        SHP,
        STD,
        SAR,
        RSD,
        SCR,
        SLL,
        SGD,
        XSU,
        SBD,
        SOS,
        SSP,
        LKR,
        SDG,
        SRD,
        SZL,
        SEK,
        CHE,
        CHW,
        SYP,
        TWD,
        TJS,
        TZS,
        THB,
        TOP,
        TTD,
        TND,
        TRY,
        TMT,
        UGX,
        UAH,
        AED,
        USN,
        UYI,
        UYU,
        UZS,
        VUV,
        VEF,
        VND,
        YER,
        ZMW,
        ZWL,
        XBA,
        XBB,
        XBC,
        XBD,
        XTS,
        XXX,
        XAU,
        XPD,
        XPT,
        XAG
    }
}
