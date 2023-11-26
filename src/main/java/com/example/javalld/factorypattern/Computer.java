package com.example.javalld.factorypattern;

public class Computer {
    private String RAM;
    private String displaySize;
    private double cost;
    private ComputerOperatingSystem computerOperatingSystem;
    private ComputerType computerType;

    public String getSpecs() {
        return "Computer{" +
                "RAM='" + RAM + '\'' +
                ", displaySize='" + displaySize + '\'' +
                ", cost=" + cost +
                ", computerOperatingSystem=" + computerOperatingSystem +
                ", computerType=" + computerType +
                '}';
    }

    public Computer(ComputerType computerType, String RAM, String displaySize, double cost, ComputerOperatingSystem computerOperatingSystem) {
        System.out.println(String.format("Creating a computer. Type: %s, RAM: %s, Display size: %s, Cost: %s, OS: %s", computerType, RAM, displaySize, cost, computerOperatingSystem));
        this.RAM = RAM;
        this.displaySize = displaySize;
        this.cost = cost;
        this.computerOperatingSystem = computerOperatingSystem;
        this.computerType = computerType;
    }
}
