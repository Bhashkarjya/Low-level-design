package src.main.java.designPatterns.decorator.pizza;

//Class of decorators
public class ToppingsDecorator extends BasePizza{
    BasePizza basePizza;

    public ToppingsDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        int basePizzaCost = basePizza.getCost();
        return basePizzaCost + 15;
    }
}
