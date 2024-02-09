package com.zerobase.heart.service;

import com.zerobase.heart.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
