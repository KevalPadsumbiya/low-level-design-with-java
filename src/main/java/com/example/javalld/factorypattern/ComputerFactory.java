package com.example.javalld.factorypattern;

public class ComputerFactory {
    public static Computer getComputer(String computerType) {
        switch (ComputerType.valueOf(computerType)) {
            case PC:
                return new Computer(ComputerType.PC, "16 GB", "15.6 inch", 250000.50, ComputerOperatingSystem.MACOS);
            case SERVER:
                return new Computer(ComputerType.SERVER, "32 GB", "14 inch", 300405, ComputerOperatingSystem.LINUX);
            default:
                return null;
        }
    }
}
