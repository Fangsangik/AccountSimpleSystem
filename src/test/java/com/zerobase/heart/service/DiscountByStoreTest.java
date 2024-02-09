package com.zerobase.heart.service;

import com.zerobase.heart.dto.PayRequest;
import com.zerobase.heart.type.ConveienceType;
import com.zerobase.heart.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByStoreTest {

    DiscountByStore discountByStore = new DiscountByStore();

    @Test
        void discountTest(){
        //given
        PayRequest G25 = new PayRequest(ConveienceType.G25, 1000, PayMethodType.Money);
        PayRequest SEVEN = new PayRequest(ConveienceType.SEVEN, 9000, PayMethodType.Money);
        PayRequest GU = new PayRequest(ConveienceType.GU, 10000, PayMethodType.Money);
        //when;
        Integer discountedAmountG25 = discountByStore.getDiscountedAmount(G25);
        Integer discountedAmountSEVEN = discountByStore.getDiscountedAmount(SEVEN);
        Integer discountedAmountGU = discountByStore.getDiscountedAmount(GU);
        //then
        assertEquals(800, discountedAmountG25);
        assertEquals(9000, discountedAmountSEVEN);
        assertEquals(9000, discountedAmountGU);
       }

}