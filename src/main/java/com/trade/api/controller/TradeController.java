package com.trade.api.controller;


import com.trade.api.dto.ResponseList;
import com.trade.api.dto.TradeDTO;
import com.trade.api.service.TradeService;
import com.trade.api.service.exeption.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rest/trades")
public class TradeController extends BaseController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/validate")
    public ResponseList validate(@RequestBody List<TradeDTO> tradeList) throws ValidationException {
        return tradeService.validate(tradeList);
    }
}
