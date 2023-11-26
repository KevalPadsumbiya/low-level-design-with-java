package com.example.javalld.parkinglot.model;

import com.example.javalld.model.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpiPayment implements PaymentStrategy {
    String upiId;
    String upiPin;

    public UpiPayment(String upiId, String upiPin) {
        this.upiId = upiId;
        this.upiPin = upiPin;
    }

    @Override
    public void pay(double amount) {
        log.info("{} is paying {} amount using UPI!", upiId, amount);
    }
}
