package com.trade.api.service.exeption;

import com.trade.api.dto.Code;
import com.trade.api.dto.ResponseError;
import com.trade.api.dto.ResponseInfo;
import com.trade.api.dto.TradeError;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ValidationException extends Exception {
    private Code code = Code.ERROR_VALIDATION;
    private UUID id;
    private List<TradeError> errors;

    public ValidationException(){
        this.id = UUID.randomUUID();
    }

    public ValidationException(Code errorCode){
        this();
        setCode(errorCode);
    }

    public ValidationException(Code errorCode, List<TradeError> validation){
        this(errorCode);
        setErrors(validation);
    }

    public ValidationException(Code errorCode, TradeError tradeError){
        this(errorCode);
        setCode(errorCode);
        this.errors = new ArrayList<>(1);
        this.errors.add(tradeError);
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<TradeError> getErrors() {
        return errors;
    }

    public void setErrors(List<TradeError> errors) {
        this.errors = errors;
    }

    public ResponseError toResponseError() {
        ResponseError responseError = new ResponseError();
        ResponseInfo response = new ResponseInfo();
        response.setId(id);
        response.setCode(code);
        response.setErrors(errors);
        responseError.setResponseInfo(response);
        return responseError;
    }
}
