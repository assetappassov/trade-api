package com.trade.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseList<E> extends ArrayList<E> implements List<E>  {

    private ResponseInfo responseInfo;

    public ResponseList(List<E> list) {
        this.addAll(list);
        responseInfo = new ResponseInfo();
        responseInfo.setCode(Code.SUCCESS);
    }

}