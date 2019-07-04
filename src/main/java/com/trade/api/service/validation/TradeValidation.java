package com.trade.api.service.validation;

import com.trade.api.dto.MessageDTO;
import com.trade.api.dto.TradeDTO;
import com.trade.api.dto.TradeError;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class TradeValidation {

    public static final String LEGAL_ENTITY = "CS Zurich";
    public static final List<String> CUSTOMERS;
    public static final Calendar now = Calendar.getInstance();

    static {
        CUSTOMERS = new ArrayList<>();
        CUSTOMERS.add("PLUTO1");
        CUSTOMERS.add("PLUTO2");

        now.set(Calendar.YEAR, 2017);
        now.set(Calendar.MONTH, 7);
        now.set(Calendar.DATE, 18);
    }

    public static List<TradeError> validate(List<TradeDTO> tradeDTOs) {

        List<TradeValidationCondition> conditions = new ArrayList<>();

        conditions.add(TradeValidationCondition.validCustormer());
        conditions.add(TradeValidationCondition.legalEntity());
        conditions.add(TradeValidationCondition.premiumCcy());
        conditions.add(TradeValidationCondition.payCcy());
        conditions.add(TradeValidationCondition.vanillaOption());
        conditions.add(TradeValidationCondition.valueDate());

        List<TradeError> errors = new ArrayList<>();

        for (TradeDTO tradeDTO : tradeDTOs) {
            List<MessageDTO> messages = new ArrayList<>(0);

            for (TradeValidationCondition condition : conditions) {
                Optional<MessageDTO> validate = condition.validate(tradeDTO);
                if (validate.isPresent()) {
                    messages.add(validate.get());
                }
            }

            if (!messages.isEmpty()) {
                errors.add(new TradeError(tradeDTO, messages));
            }
        }

        return errors;
    }
}
