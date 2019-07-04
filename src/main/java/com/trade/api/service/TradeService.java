package com.trade.api.service;

import com.trade.api.dto.Code;
import com.trade.api.dto.ResponseList;
import com.trade.api.dto.TradeDTO;
import com.trade.api.dto.TradeError;
import com.trade.api.service.exeption.ValidationException;
import com.trade.api.service.validation.TradeValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TradeService {

    public ResponseList validate(List<TradeDTO> tradeList) throws ValidationException {
        List<TradeError> errors = TradeValidation.validate(tradeList);

        if(errors.size() > 0){
            throw new ValidationException(Code.ERROR_VALIDATION, errors);
        }

        return new ResponseList(tradeList);
    }
}