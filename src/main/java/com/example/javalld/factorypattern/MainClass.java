package com.example.javalld.factorypattern;

public class MainClass {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC");
        Computer server = ComputerFactory.getComputer("SERVER");
    }
}
