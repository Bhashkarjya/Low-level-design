package creational.builder;

import java.util.*;
public class BuilderDemo {
    public static void main(String[] args) {
        // Build Car 1 with 4 seats, 40L fuel capacity, no sunroof, with model Creta and company Hyundai
        Car.CarBuilder builder = new Car.CarBuilder();

        Car car1 = builder.setCompany("Hyundai")
                .setModel("Creta")
                .setPrice(700000)
                .setFuelCapacity(40)
                .setSeatCapacity(4)
                .setSunRoof(false)
                .build();

        //Build Car 2 with 7 seats, 60L fuel capacity, with sunroof, with model XUV700 and company Mahindra
        Car car2 = builder.setCompany("Mahindra")
                .setModel("XUV700")
                .setPrice(2800000)
                .setFuelCapacity(60)
                .setSunRoof(true)
                .setSeatCapacity(7)
                .build();

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}
