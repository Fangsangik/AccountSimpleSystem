package com.zerobase.heart.dto;

import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.type.PayCancelResult;

public class PayCancelResponse {
   PayCancelResult payCancelResult;

   Integer payAmount;


    public PayCancelResponse(PayCancelResult payCancelResult, Integer payAmount) {
        this.payCancelResult = payCancelResult;
        this.payAmount = payAmount;
    }

    public PayCancelResult getPayCancelResult() {
        return payCancelResult;
    }

    public void setPayCancelResult(PayCancelResult payCancelResult) {
        this.payCancelResult = payCancelResult;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    @Override
    public String toString() {
        return "PayCancelResponse{" +
                "payCancelResult=" + payCancelResult +
                ", payAmount=" + payAmount +
                '}';
    }
}
