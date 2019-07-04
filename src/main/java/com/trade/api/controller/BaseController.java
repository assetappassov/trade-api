package com.trade.api.controller;

import com.trade.api.dto.ResponseError;
import com.trade.api.service.exeption.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {

    public Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseError handleException(Exception ex) {
        ValidationException ae = (ValidationException) ex;
        logger.error("API.ERROR:{}:{}", ae.getId(), ae.getCode(), ex);
        return ae.toResponseError();
    }
}
