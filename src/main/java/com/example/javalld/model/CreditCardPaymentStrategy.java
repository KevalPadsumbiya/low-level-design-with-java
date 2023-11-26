package com.example.javalld.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class CreditCardPaymentStrategy implements PaymentStrategy {
    String cardNo;
    String cardHolderName;
    String dateOfExpiry;
    String cvv;

    @Override
    public void pay(double amount) {
        log.info("{} is paying {} amount using credit card!", cardHolderName, amount);
    }
}
