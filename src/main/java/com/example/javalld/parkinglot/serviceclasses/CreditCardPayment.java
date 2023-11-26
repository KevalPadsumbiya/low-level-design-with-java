package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.model.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreditCardPayment implements PaymentStrategy {
    String cardNo;
    String cardHolderName;
    String dateOfExpiry;
    String cvv;

    public CreditCardPayment(String cardHolderName, String cardNo, String dateOfExpiry, String cvv) {
        this.cardHolderName = cardHolderName;
        this.cardNo = cardNo;
        this.dateOfExpiry = dateOfExpiry;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        log.info("{} is paying {} amount using credit card!", cardHolderName, amount);
    }
}
