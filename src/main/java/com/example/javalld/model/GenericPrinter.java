package com.example.javalld.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericPrinter<T> {

    T valueToBePrinted;

    public GenericPrinter(T valueToBePrinted) {
        this.valueToBePrinted = valueToBePrinted;
    }

    public void print() {
        log.info("Printing from generic class: {}", valueToBePrinted);
    }
}
