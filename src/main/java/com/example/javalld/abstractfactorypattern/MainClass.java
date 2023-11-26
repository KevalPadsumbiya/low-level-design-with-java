package com.example.javalld.abstractfactorypattern;

public class MainClass {
    public static void main(String[] args) {
        AbstractDeviceFactory mobileFactory = FactoryProvider.getFactory(Factory.MOBILE_FACTORY);
        mobileFactory.createDevice("NORMAL");
        mobileFactory.createDevice("FOLDABLE");

        AbstractDeviceFactory computerFactory = FactoryProvider.getFactory(Factory.COMPUTER_FACTORY);
        computerFactory.createDevice("PC");
        computerFactory.createDevice("SERVER");
    }
}
