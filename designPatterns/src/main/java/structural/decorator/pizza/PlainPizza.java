package structural.decorator.pizza;

public class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "It is a Plain pizza";
    }

    @Override
    public int getCost() {
        return 50;
    }
}
