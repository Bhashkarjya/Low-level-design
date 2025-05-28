package src.main.java.designPatterns.strategy;

public class WalkStrategy implements RouteStrategy {
    @Override
    public void buildRoute(Coordinate a, Coordinate b) {
        System.out.println("Walking route built");
    }
}