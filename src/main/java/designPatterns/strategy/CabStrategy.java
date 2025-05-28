package src.main.java.designPatterns.strategy;

public class CabStrategy implements RouteStrategy {
    @Override
    public void buildRoute(Coordinate a, Coordinate b) {
        System.out.println("Cab route built");
    }
}