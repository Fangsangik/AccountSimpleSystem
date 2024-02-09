package com.zerobase.heart.service;

import com.zerobase.heart.type.*;

public class CardAdapter implements PaymentInterface{
    //인증
    public void authorized() {
        System.out.println("authorization success");
    }

    //승인
    public void accept() {
        System.out.println("appected");
    }

    //매입
    public CardUseResult buy(Integer payAmount) {
        if (payAmount > 100) {
            return CardUseResult.use_failed;
        }
        return CardUseResult.use_success;
    }

    //매입 취소
    public CardUseCancelResult cancelBuy(Integer payAmount) {
        if (payAmount < 1000) {
            return CardUseCancelResult.use_cancel_failed;
        }

        return CardUseCancelResult.use_cancel_success;
    }

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.Card;
    }

    @Override
    public PaymentResult usePayment(Integer payAmount) {
       authorized();
       accept();
        CardUseResult cardUseResult = buy(payAmount);

        if (cardUseResult == CardUseResult.use_failed){
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public PaymentCancel cancelPayment(Integer cancelAmount) {
        authorized();
        accept();
        CardUseCancelResult cardUseCancelResult = cancelBuy(cancelAmount);

        if (cardUseCancelResult == CardUseCancelResult.use_cancel_failed){
            return PaymentCancel.PAYMENT_CANCEL_FAIL;
        }
        return PaymentCancel.PAYMENT_CANCEL_SUCCESS;
    }
}
