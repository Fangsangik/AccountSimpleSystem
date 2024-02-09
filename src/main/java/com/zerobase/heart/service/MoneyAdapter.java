package com.zerobase.heart.service;

import com.zerobase.heart.type.*;

public class MoneyAdapter implements PaymentInterface {

    public MoneyUseResult moneyUse(Integer payAmount) {
        System.out.println("MoneyAdapter.use = " + payAmount);
        if (payAmount > 100_000) {
            return MoneyUseResult.useFail;
        }
        return MoneyUseResult.useSuccess;
    }

    public MoneyUseCancelResult cancelMoneyUse(Integer payAmount) {

        System.out.println("MoneyAdapter.useCancel" + payAmount);
        if (payAmount < 100) {
            return MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL;
        }
        return MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS;
    }

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.Money;
    }

    @Override
    public PaymentResult usePayment(Integer payAmount) {
        MoneyUseResult moneyUseResult = moneyUse(payAmount);
        if (moneyUseResult == MoneyUseResult.useFail) {
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public PaymentCancel cancelPayment(Integer cancelAmount) {
       MoneyUseCancelResult moneyUseCancelResult = cancelMoneyUse(cancelAmount);

       if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL){
           return PaymentCancel.PAYMENT_CANCEL_FAIL;
       }
       return PaymentCancel.PAYMENT_CANCEL_SUCCESS;
    }
}
