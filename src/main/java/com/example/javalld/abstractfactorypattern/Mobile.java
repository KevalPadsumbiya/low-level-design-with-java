package com.example.javalld.abstractfactorypattern;

public class Mobile implements Device {
    private String RAM;
    private String displaySize;
    private double cost;
    private MobileOperatingSystem mobileOperatingSystem;
    private MobileType mobileType;

    public Mobile(MobileType mobileType, String RAM, String displaySize, double cost, MobileOperatingSystem mobileOperatingSystem) {
        System.out.println(String.format("Creating a mobile. Company: %s, RAM: %s, Display size: %s, Cost: %s, OS: %s", mobileType, RAM, displaySize, cost, mobileOperatingSystem));
        this.mobileType = mobileType;
        this.RAM = RAM;
        this.displaySize = displaySize;
        this.cost = cost;
        this.mobileOperatingSystem = mobileOperatingSystem;
    }

    @Override
    public String getSpecs() {
        return String.format("RAM: %s, displaySize: %s, cost: %s, operatingSystem: %s",
                RAM, displaySize, cost, mobileOperatingSystem);
    }
}
