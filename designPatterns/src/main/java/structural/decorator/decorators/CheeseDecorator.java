package structural.decorator.decorators;

import structural.decorator.pizza.BasePizza;

public class CheeseDecorator extends BaseDecorator {
    public CheeseDecorator(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return this.basePizza.getDescription() + " with Cheese toppings";
    }

    @Override
    public int getCost() {
        return this.basePizza.getCost() + 20;
    }
}
