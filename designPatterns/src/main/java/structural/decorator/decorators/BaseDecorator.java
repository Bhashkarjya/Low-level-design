package structural.decorator.decorators;

import structural.decorator.pizza.BasePizza;

public abstract class BaseDecorator implements BasePizza {
    protected final BasePizza basePizza;

    BaseDecorator(BasePizza pizza) {
        this.basePizza = pizza;
    }
}
