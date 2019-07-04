package com.trade.api.service.validation;

import com.trade.api.dto.MessageCode;
import com.trade.api.dto.MessageDTO;
import com.trade.api.dto.TradeDTO;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: AAA <asset.appassov@gmail.com>
 * Date: 7/23/19.
 */

@FunctionalInterface
public interface TradeValidationCondition {

    Optional<MessageDTO> validate(final TradeDTO tradeDTO);

    static TradeValidationCondition validCustormer() {
        return (tradeDTO) -> {

            if (!TradeValidation.CUSTOMERS.contains(tradeDTO.getCustomer())) {
                return Optional.of(new MessageDTO(MessageCode.CUSTOMER, "Customer is not one of the supported ones."));
            }
            return Optional.empty();
        };
    }

    static TradeValidationCondition legalEntity() {
        return (tradeDTO) -> {

            if (tradeDTO.getLegalEntity() == null || tradeDTO.getLegalEntity().isEmpty()) {
                return Optional.of(new MessageDTO(MessageCode.LEGAL_ENTITY, "Legal entity cannot be empty."));
            }

            if (!TradeValidation.LEGAL_ENTITY.equals(tradeDTO.getLegalEntity())) {
                return Optional.of(new MessageDTO(MessageCode.LEGAL_ENTITY, "Legal entity is not supported."));
            }
            return Optional.empty();
        };
    }

    static TradeValidationCondition valueDate() {
        return (tradeDTO) -> {

            Date valueDate = tradeDTO.getValueDate();
            if (valueDate != null) {
                if (valueDate.compareTo(tradeDTO.getTradeDate()) == 1) {
                    return Optional.of(new MessageDTO(MessageCode.VALUE_DATE, "Value date cannot be before trade date."));
                }

                Calendar valueDateCalendar = Calendar.getInstance();
                valueDate.setTime(valueDate.getTime());
                int dayOfWeek = valueDateCalendar.get(Calendar.DAY_OF_WEEK);

                if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                    return Optional.of(new MessageDTO(MessageCode.VALUE_DATE, "Value date cannot fall on weekend or non-working day for currency."));
                }
            }

            if (Arrays.asList(TradeDTO.Type.Spot, TradeDTO.Type.Forward).contains(tradeDTO.getType())) {
                if (tradeDTO.getValueDate().compareTo(TradeValidation.now.getTime()) == 1) {
                    return Optional.of(new MessageDTO(MessageCode.VALUE_DATE, "Value date cannot be before current date."));
                }
            }

            return Optional.empty();
        };
    }

    static TradeValidationCondition premiumCcy() {
        return (tradeDTO) -> {

            List<String> currencies = Arrays.stream(TradeDTO.CCY.values())
                    .map(r -> r.name())
                    .collect(Collectors.toList());

            if (!currencies.contains(tradeDTO.getPayCcy())) {
                return Optional.of(new MessageDTO(MessageCode.PREMIUM_CCY, "Currency is not valid."));
            }

            return Optional.empty();
        };
    }

    static TradeValidationCondition payCcy() {
        return (tradeDTO) -> {

            List<String> currencies = Arrays.stream(TradeDTO.CCY.values())
                    .map(r -> r.name())
                    .collect(Collectors.toList());

            if (!currencies.contains(tradeDTO.getPayCcy())) {
                return Optional.of(new MessageDTO(MessageCode.PAY_CCY, "Currency is not valid."));
            }

            return Optional.empty();
        };
    }

    static TradeValidationCondition vanillaOption() {
        return (tradeDTO) -> {

            if (TradeDTO.Type.VanillaOption.equals(tradeDTO.getType())) {
                if (!TradeDTO.Style.AMERICAN.name().equals(tradeDTO.getStyle())) {
                    if (!TradeDTO.Style.EUROPEAN.name().equals(tradeDTO.getStyle())) {
                        return Optional.of(new MessageDTO(MessageCode.VALUE_DATE, "The style has to be either American or European."));
                    }
                } else {
                    if (tradeDTO.getExcerciseStartDate() == null) {
                        return Optional.of(new MessageDTO(MessageCode.EXCERCISE_START_DATE, "Excercise startd is required."));
                    } else {
                        if (tradeDTO.getExcerciseStartDate().compareTo(tradeDTO.getTradeDate()) == 1) {
                            return Optional.of(new MessageDTO(MessageCode.EXCERCISE_START_DATE, "Excercise startd has to be after the trade date."));
                        }

                        if (tradeDTO.getExcerciseStartDate().compareTo(tradeDTO.getExpiryDate()) == -1) {
                            return Optional.of(new MessageDTO(MessageCode.EXCERCISE_START_DATE, "Excercise startd date has to be before the expiry date."));
                        }
                    }
                }

                if (tradeDTO.getExpiryDate().compareTo(tradeDTO.getDeliveryDate()) == -1) {
                    return Optional.of(new MessageDTO(MessageCode.EXPIRE_DATE, "Expiry date shall be before delivery date."));
                }

                if (tradeDTO.getPremiumDate().compareTo(tradeDTO.getDeliveryDate()) == -1) {
                    return Optional.of(new MessageDTO(MessageCode.PREMIUM_DATE, "Premium date shall be before delivery date."));
                }
            }

            return Optional.empty();
        };
    }
}
