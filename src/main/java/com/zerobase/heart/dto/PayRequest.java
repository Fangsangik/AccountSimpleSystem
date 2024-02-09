package com.zerobase.heart.dto;

import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.type.PayMethodType;

public class PayRequest {
    //편의점 종류
    ConveienceType convienceType;

    //결제 금액
    Integer payAmount;

    //결제 수단
    PayMethodType payMethodType;

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    public PayRequest(ConveienceType convienceType, Integer payAmount, PayMethodType payMethodType) {
        this.convienceType = convienceType;
        this.payAmount = payAmount;
        this.payMethodType = payMethodType;
    }

    public ConveienceType getConvienceType() {
        return convienceType;
    }

    public void setConvienceType(ConveienceType convienceType) {
        this.convienceType = convienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
