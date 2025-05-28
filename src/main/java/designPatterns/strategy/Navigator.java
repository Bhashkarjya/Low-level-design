package src.main.java.designPatterns.strategy;

public class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(Coordinate a, Coordinate b) {
        strategy.buildRoute(a,b);
    }
}
