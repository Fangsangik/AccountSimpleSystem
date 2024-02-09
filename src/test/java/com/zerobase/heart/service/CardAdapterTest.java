package com.zerobase.heart.service;

import com.zerobase.heart.type.CardUseCancelResult;
import com.zerobase.heart.type.CardUseResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {

    CardAdapter cardAdapter = new CardAdapter();

    @Test
    void capture_success() {
        //given
        Integer payAmount = 99;
        //when
        CardUseResult cardUseResult = cardAdapter.buy(payAmount);
        //then
        assertEquals(CardUseResult.use_success, cardUseResult);
    }


    @Test
    void capture_fail() {
        //given
        Integer payAmount = 101;
        //when
        CardUseResult cardUseResult = cardAdapter.buy(payAmount);
        //then
        assertEquals(CardUseResult.use_failed, cardUseResult);
    }

    @Test
    void cancel_capture_success() {
        //given
        Integer cancelAmount = 1001;
        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelBuy(cancelAmount);
        //then
        assertEquals(CardUseCancelResult.use_cancel_success, cardUseCancelResult);
    }

    @Test
    void cancel_capture_fail() {
        //given
        Integer cancelAmount = 999;
        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelBuy(cancelAmount);
        //then
        assertEquals(CardUseCancelResult.use_cancel_failed, cardUseCancelResult);
    }
}