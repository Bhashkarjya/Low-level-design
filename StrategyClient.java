

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.main.java.designPatterns.strategy.BusStrategy;
import src.main.java.designPatterns.strategy.CabStrategy;
import src.main.java.designPatterns.strategy.Coordinate;
import src.main.java.designPatterns.strategy.Navigator;
import src.main.java.designPatterns.strategy.RouteStrategy;
import src.main.java.designPatterns.strategy.WalkStrategy;

public class StrategyClient {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static RouteStrategy strategy;
    public static void main(String[] args) throws IOException{

        System.out.println("Enter the X coordinate of the source : ");
        int sourceXCoordinate = Integer.parseInt(reader.readLine());

        System.out.println("Enter the Y coordinate of the source : ");
        int sourceYCoordinate = Integer.parseInt(reader.readLine());

        System.out.println("Enter the X coordinate of the destination : ");
        int destinationXCoordinate = Integer.parseInt(reader.readLine());

        System.out.println("Enter the Y coordinate of the destination : ");
        int destinationYCoordinate = Integer.parseInt(reader.readLine());

        Coordinate source = new Coordinate(sourceXCoordinate, sourceYCoordinate);
        Coordinate destination = new Coordinate(destinationXCoordinate, destinationYCoordinate);

        Navigator navigator = new Navigator();

        System.out.println("Choose the route strategy : \n" + 
                           "1 - Bus " + "\n" +
                           "2 - Walk " + "\n" +
                           "3 - Cab " + "\n");
        
        String userInput = reader.readLine();

        if(userInput.equals("1")) {
            strategy = new BusStrategy();        
        }
        else if(userInput.equals("2")) {
            strategy = new WalkStrategy();
        }
        else if(userInput.equals("3")) {
            strategy = new CabStrategy();
        }

        navigator.setStrategy(strategy);
        navigator.navigate(source, destination);

    }
}
