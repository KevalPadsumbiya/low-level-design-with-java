package com.example.javalld.programs;

import com.example.javalld.model.GenericPrinter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericsExample {

    public static void main(String[] args) {
        GenericPrinter<Integer> integerPrinter = new GenericPrinter<>(10);
        integerPrinter.print();

        GenericPrinter<String> stringPrinter = new GenericPrinter<>("Keval");
        stringPrinter.print();

        GenericPrinter<Double> doublePrinter = new GenericPrinter<>(100.51);
        doublePrinter.print();

        genericPrinterMethod(10);
        genericPrinterMethod("Keval");
        genericPrinterMethod(100.51);
    }

    public static <T> void genericPrinterMethod(T valueToBePrinted) {
        log.info("Printed using genetic method: {}", valueToBePrinted);
    }
}
