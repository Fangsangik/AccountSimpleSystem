package com.zerobase.heart.dto;

import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.type.PayMethodType;

public class PayCancelRequest {
    //편의점 종류
    ConveienceType conveienceType;
    //취소금액
    Integer payCancelAmount;

    PayMethodType payMethodType;

    public PayCancelRequest(ConveienceType conveienceType, Integer payCancelAmount, PayMethodType payMethodType) {
        this.conveienceType = conveienceType;
        this.payCancelAmount = payCancelAmount;
        this.payMethodType = payMethodType;
    }

    public ConveienceType getConveienceType() {
        return conveienceType;
    }

    public void setConveienceType(ConveienceType conveienceType) {
        this.conveienceType = conveienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
