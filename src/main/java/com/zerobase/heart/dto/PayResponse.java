package com.zerobase.heart.dto;

import com.zerobase.heart.type.PayResult;

public class PayResponse {
    //결제 결과
    PayResult PayResult;

    //결제 성공 금액
    Integer paidAmount;


    public PayResponse(PayResult payResult, Integer paidAmount) {
        PayResult = payResult;
        this.paidAmount = paidAmount;
    }

    public com.zerobase.heart.type.PayResult getPayResult() {
        return PayResult;
    }

    public void setPayResult(com.zerobase.heart.type.PayResult payResult) {
        PayResult = payResult;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "PayResponse{" +
                "PayResult=" + PayResult +
                ", paidAmount=" + paidAmount +
                '}';
    }
}
