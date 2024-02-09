package com.zerobase.heart.service;

import com.zerobase.heart.type.MoneyUseCancelResult;
import com.zerobase.heart.type.MoneyUseResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.zerobase.heart.type.MoneyUseResult.useFail;
import static com.zerobase.heart.type.MoneyUseResult.useSuccess;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {

    MoneyAdapter moneyAdapter = new MoneyAdapter();

    @Test
    void moeneyUseFail() {
        //given
        Integer payAmount = 100001;
        //when
        MoneyUseResult rst = moneyAdapter.moneyUse(payAmount);
        //then
        Assertions.assertEquals(useFail, rst);
    }

    @Test
    void moneyUseSuccess() {
        //given
        Integer payAmount = 100;
        //when
        MoneyUseResult rst = moneyAdapter.moneyUse(payAmount);
        //then
        assertEquals(useSuccess, rst);
    }

    @Test
    void money_use_cancel_success() {
        //given
        Integer payCancelAmount = 101;
        //when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.cancelMoneyUse(payCancelAmount);
        //then
        assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS, moneyUseCancelResult);
    }


    @Test
           void money_use_cancel_fail() {
        //given
        Integer payCancelAmount = 99;
        //when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.cancelMoneyUse(payCancelAmount);
        //then
        assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL,moneyUseCancelResult);
    }

}