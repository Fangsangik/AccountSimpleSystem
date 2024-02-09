package com.zerobase.heart.service;

import com.zerobase.heart.dto.PayRequest;

public class DiscountByPayment implements DiscountInterface {
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethodType()) {

            case Money -> {
                return payRequest.getPayAmount() * 7 / 10;
            }
            case Card -> {
                return payRequest.getPayAmount() * 9 / 10;
            }
        }

        return payRequest.getPayAmount();
    }
}
