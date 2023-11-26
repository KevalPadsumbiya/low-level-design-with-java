package com.example.javalld.abstractfactorypattern;

public class FactoryProvider {
    public static AbstractDeviceFactory getFactory(Factory factory) {
        switch (factory) {
            case MOBILE_FACTORY:
                return new MobileFactory();
            case COMPUTER_FACTORY:
                return new ComputerFactory();
            default:
                return null;
        }
    }
}
