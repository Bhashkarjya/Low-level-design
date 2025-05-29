import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.main.java.designPatterns.decorator.pizza.BasePizza;
import src.main.java.designPatterns.decorator.pizza.CheeseDecorator;
import src.main.java.designPatterns.decorator.pizza.MarghertiaPizza;
import src.main.java.designPatterns.decorator.pizza.ToppingsDecorator;
import src.main.java.designPatterns.decorator.pizza.VegPizza;

public class DecoratorClient2 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        BasePizza vegPizza = new VegPizza(50);
        BasePizza margheritaPizza = new MarghertiaPizza(70);

        System.out.println("Choose your pizza : \n" + 
             "1. Veg Pizza \n" + 
             "2. Margherita Pizza \n");
        int pizzaType = Integer.parseInt(reader.readLine());
        
        if(pizzaType == 1) {
            System.out.println("Would you like extra cheese (Y/N) ?");
            String cheeseChoice = reader.readLine();
            if(cheeseChoice.equals("Y")) {
                vegPizza = new CheeseDecorator(vegPizza);
            }

            System.out.println("Would you like extra toppings (Y/N) ?");
            String toppingsChoice = reader.readLine();
            if(toppingsChoice.equals("Y")) {
                vegPizza = new ToppingsDecorator(vegPizza);
            }

            int totalCost = vegPizza.getCost();
            System.out.println("Total Cost : " + totalCost);
        }
        else {
            System.out.println("Would you like extra cheese (Y/N) ?");
            String cheeseChoice = reader.readLine();
            if(cheeseChoice.equals("Y")) {
                margheritaPizza = new CheeseDecorator(margheritaPizza);
            }

            System.out.println("Would you like extra toppings (Y/N) ?");
            String toppingsChoice = reader.readLine();
            if(toppingsChoice.equals("Y")) {
                margheritaPizza = new ToppingsDecorator(margheritaPizza);
            }

            int totalCost = margheritaPizza.getCost();
            System.out.println("Total Cost : " + totalCost);
        }

        

    }
}