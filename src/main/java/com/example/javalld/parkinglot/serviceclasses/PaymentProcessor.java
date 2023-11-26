package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.model.PaymentStrategy;
import com.example.javalld.parkinglot.exceptions.InvalidPaymentType;
import com.example.javalld.parkinglot.model.PaymentType;
import com.example.javalld.parkinglot.model.Ticket;
import com.example.javalld.parkinglot.model.UpiPayment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentProcessor {
    public void collectPayment(Ticket ticket, PaymentType paymentType, Double amount) throws InvalidPaymentType {
        switch (paymentType) {
            case UPI:
                PaymentStrategy paymentStrategy = new UpiPayment("abc@paytm", "1234");
                paymentStrategy.pay(amount);
                break;
            case CREDIT_CARD:
                paymentStrategy = new CreditCardPayment("Keval", "123456", "01-12-2025", "287");
                paymentStrategy.pay(amount);
                break;
            default:
                throw new InvalidPaymentType("Invalid payment type!");
        }
    }
}
