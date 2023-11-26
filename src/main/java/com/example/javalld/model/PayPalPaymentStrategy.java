package com.example.javalld.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class PayPalPaymentStrategy implements PaymentStrategy {
    String userName;
    String passWord;

    @Override
    public void pay(double amount) {
        log.info("{} is paying {} amount using PayPal!", this.userName, amount);
    }
}
