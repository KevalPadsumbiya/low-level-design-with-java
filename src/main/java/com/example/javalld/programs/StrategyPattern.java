package com.example.javalld.programs;

import com.example.javalld.model.CreditCardPaymentStrategy;
import com.example.javalld.model.PayPalPaymentStrategy;
import com.example.javalld.model.PaymentStrategy;

public class StrategyPattern {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = CreditCardPaymentStrategy.builder().cardNo("abcd")
                .cardHolderName("Keval")
                .cvv("123")
                .dateOfExpiry("2025-05-05")
                .build();

        paymentStrategy.pay(120.53);

        paymentStrategy = PayPalPaymentStrategy.builder().userName("Keval").passWord("Password").build();

        paymentStrategy.pay(105.82);
    }
}
