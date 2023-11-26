package com.example.javalld;

import com.example.javalld.parkinglot.model.VehicleType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class TestingClass {

    public static class Sample {
        int a;
        String s;
        boolean b;
        double d;
        Object o;

        public Sample(int i) {
            this.a = i;
        }

        public Sample() {

        }
    }

    public class a {
        int a;

        public int show() {
            return 1;
        }

        public int show1() {
            return 1;
        }
    }

    public class b extends a {
        public void show(int b) {
        }

        @Override
        public int show() {
            super.show1();
            super.a = 10;
            return 1;
        }
    }

    public static void main(String[] args) {
//        "{\"#n0\":\"activation_ts\",\"#kn0\":\"partner\",\"#kn1\":\"activation_status\"}"
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.forEach(el -> System.out.println(el));
        Map<String, Integer> map = new TreeMap<>();
        map.put("Keval", 405);
        map.put("Shivam", 406);
        map.put("Keval", 405);
        map.put("Keval", 406);

        VehicleType vehicleType = VehicleType.CAR;
        switch (vehicleType) {
            case CAR:
                log.info("Car");
                break;
            case TRUCK:
                log.info("Truck");
                break;
            default:
                log.info("Default");
                break;
        }

        Sample sample = new Sample();
        Sample sample1 = new Sample();
//        if(sample.equals(sample1))
//        int a=10;
    }

    public void abc() {
    }

    public void abc(int a) {
    }
}
