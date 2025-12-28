package structural.decorator.pizza;

public class Farmhouse implements BasePizza {
    @Override
    public String getDescription() {
        return "It is a Farmhouse pizza";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
