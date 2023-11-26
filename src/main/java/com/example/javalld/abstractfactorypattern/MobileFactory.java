package com.example.javalld.abstractfactorypattern;

import static com.example.javalld.abstractfactorypattern.MobileType.FOLDABLE;
import static com.example.javalld.abstractfactorypattern.MobileType.NORMAL;

public class MobileFactory extends AbstractDeviceFactory {

    @Override
    Device createDevice(String mobileType) {

        switch (MobileType.valueOf(mobileType)) {
            case NORMAL:
                return new Mobile(NORMAL, "12 GB", "6.5 inch", 125000, MobileOperatingSystem.IOS);
            case FOLDABLE:
                return new Mobile(FOLDABLE, "16 GB", "6.8 inch", 115000, MobileOperatingSystem.ANDROID);
            default:
                return null;
        }
    }
}
