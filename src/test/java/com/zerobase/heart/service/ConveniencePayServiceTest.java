package com.zerobase.heart.service;

import com.zerobase.heart.ApplicationConfig;
import com.zerobase.heart.dto.PayCancelRequest;
import com.zerobase.heart.dto.PayCancelResponse;
import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.dto.PayRequest;
import com.zerobase.heart.dto.PayResponse;
import com.zerobase.heart.type.PayCancelResult;
import com.zerobase.heart.type.PayMethodType;
import com.zerobase.heart.type.PayResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ApplicationConfig config = new ApplicationConfig();
    ConveniencePayService conveniencePayService = config.conveniencePayService();

    @Test
    void Pay_Success() {
        //given
        PayRequest payRequest = new PayRequest(ConveienceType.G25, 50, PayMethodType.Money);

        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(35, payResponse.getPaidAmount());
    }

    @Test
    void Pay_Fail() {
        //given
        PayRequest payRequest = new PayRequest(ConveienceType.G25, 1500_001, PayMethodType.Money);

        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPaidAmount());
    }

    @Test
    void pay_cancel_fail() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConveienceType.G25, 99, PayMethodType.Money);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.cancelPay(payCancelRequest);
        //then
        assertEquals(PayCancelResult.FAIL, payCancelResponse.getPayCancelResult());
        assertEquals(0, payCancelResponse.getPayAmount());
    }

    @Test
    void pay_cancel_success() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConveienceType.G25, 1000, PayMethodType.Money);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.cancelPay(payCancelRequest);
        //then
        assertEquals(PayCancelResult.SUCCESS, payCancelResponse.getPayCancelResult());
        assertEquals(1000, payCancelResponse.getPayAmount());
    }
}