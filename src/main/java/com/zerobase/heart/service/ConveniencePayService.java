package com.zerobase.heart.service;

import com.zerobase.heart.dto.*;
import com.zerobase.heart.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService {

    private final Map<PayMethodType,PaymentInterface> paymentInterfaceMap = new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet, DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(paymentInterface.getPayMethodType(),
                        paymentInterface)
        );
        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequest payRequest){
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());

        /*
        예외 case를 중간에 처리, 하나의 성공 case를 마지막에 처리
         */
        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.usePayment(discountedAmount);

        //FailCase
        if (payment == PaymentResult.PAYMENT_FAIL ){
            return new PayResponse(PayResult.FAIL, 0);
        }

        //SuccessCase
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    public PayCancelResponse cancelPay(PayCancelRequest payCancelRequest){
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        PaymentCancel paymentCancelResult =
                paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        //fail
        if (paymentCancelResult == PaymentCancel.PAYMENT_CANCEL_FAIL){
            return new PayCancelResponse(PayCancelResult.FAIL, 0);
        }

        //success
        return new PayCancelResponse(PayCancelResult.SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
