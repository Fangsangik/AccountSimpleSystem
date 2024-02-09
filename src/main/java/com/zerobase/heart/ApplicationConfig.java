package com.zerobase.heart;

import com.zerobase.heart.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
//전체 설정
public class ApplicationConfig {

    @Bean
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(
                getMoneyAdapter(), getCardAdapter())),
                new DiscountByPayment());
    }

    @Bean
    public static CardAdapter getCardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public static MoneyAdapter getMoneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public static DiscountByStore discountByStore() {
        return new DiscountByStore();
    }
}
