package com.example.javalld.parkinglot.exceptions;

public class InvalidPaymentType extends Exception {
    public InvalidPaymentType(String error) {
        super(error);
    }
}
