package structural.decorator;

import structural.decorator.decorators.CheeseDecorator;
import structural.decorator.decorators.MushroomDecorator;
import structural.decorator.pizza.BasePizza;
import structural.decorator.pizza.Farmhouse;
import structural.decorator.pizza.PlainPizza;

public class Main {
    public static void main(String[] args) {
        //Create a plain pizza
        BasePizza plainPizza = new PlainPizza();
        System.out.println("Order 1 : " + plainPizza.getDescription() + " costing " + plainPizza.getCost());

        //Create a farmhouse pizza
        BasePizza farmhouse = new Farmhouse();
        System.out.println("Order 2 : " + farmhouse.getDescription() + " costing " + plainPizza.getCost());

        //Add Cheese toppings to the plain pizza
        BasePizza pizza2 = new CheeseDecorator(plainPizza);
        System.out.println("Order 3 : " + pizza2.getDescription() + " costing " + pizza2.getCost());

        //Add Mushroom toppings to the farmhouse pizza
        BasePizza pizza3 = new MushroomDecorator(farmhouse);
        System.out.println("Order 4 : " + pizza3.getDescription() + " costing " + pizza3.getCost());


    }
}
