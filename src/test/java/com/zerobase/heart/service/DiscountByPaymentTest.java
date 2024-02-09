package com.zerobase.heart.service;

import com.zerobase.heart.dto.PayRequest;
import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPaymentTest {
    DiscountByPayment discountByPayment = new DiscountByPayment();

    @Test
        void discountSuccess(){
        //given
        PayRequest money = new PayRequest(ConveienceType.G25, 10000, PayMethodType.Money);
        PayRequest card = new PayRequest(ConveienceType.GU, 10000, PayMethodType.Card);
        //when
        Integer discountByMoney = discountByPayment.getDiscountedAmount(money);
        Integer discountByCard = discountByPayment.getDiscountedAmount(card);
        //then
        assertEquals(7000, discountByMoney);
        assertEquals(9000, discountByCard);
       }
}