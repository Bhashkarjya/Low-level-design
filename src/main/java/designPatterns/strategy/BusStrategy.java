package src.main.java.designPatterns.strategy;

public class BusStrategy implements RouteStrategy {
    @Override
    public void buildRoute(Coordinate a, Coordinate b) {
        System.out.println("Bus route built");
    }
}