package structural.decorator.pizza;

public class Margherita implements BasePizza {
    @Override
    public String getDescription() {
        return "It is a Margherita pizza";
    }

    @Override
    public int getCost() {
        return 80;
    }
}
