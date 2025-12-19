package creational.abstractFactory;

import creational.abstractFactory.abstractFactory.FurnitureFactory;
import creational.abstractFactory.abstractFactory.ModernFactory;
import creational.abstractFactory.abstractFactory.VictorianFactory;
import creational.abstractFactory.sofa.*;
import creational.abstractFactory.chair.*;

import java.security.Provider;
import java.util.*;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the type of furniture (Modern/Victorian) ? ");
        String furnitureType = sc.nextLine();
        FurnitureFactory factory;

        if (furnitureType.equals("Modern")) {
           factory = new ModernFactory();
        }
        else if( furnitureType.equals("Victorian")) {
            factory = new VictorianFactory();
        }
        else {
            throw  new IllegalArgumentException("Invalid type of furniture");
        }

        Chair chair = factory.getChair();
        Sofa sofa = factory.getSofa();
        chair.chairType();
        sofa.sofaType();
    }
}
