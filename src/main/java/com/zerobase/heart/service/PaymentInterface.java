package com.zerobase.heart.service;

import com.zerobase.heart.type.PayMethodType;
import com.zerobase.heart.type.PaymentCancel;
import com.zerobase.heart.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult usePayment(Integer payAmount);

    PaymentCancel cancelPayment(Integer payCancelAmount);
}
