package structural.decorator.decorators;

import structural.decorator.pizza.BasePizza;

public class MushroomDecorator extends BaseDecorator {
    public MushroomDecorator(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return this.basePizza.getDescription() + " with Mushroom toppings";
    }

    @Override
    public int getCost() {
        return this.basePizza.getCost() + 30;
    }
}
