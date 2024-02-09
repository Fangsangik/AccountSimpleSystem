package com.zerobase.heart.service;

import com.zerobase.heart.dto.PayRequest;

public class DiscountByStore implements DiscountInterface {
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getConvienceType()) {

            case G25 -> {
                return payRequest.getPayAmount() * 8 / 10;
            }
            case GU -> {
                return payRequest.getPayAmount() * 9 / 10;
            }
            case SEVEN -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
