package src.main.java.designPatterns.decorator.pizza;

//Class of decorators
public class CheeseDecorator extends BasePizza{
    BasePizza basePizza;

    public CheeseDecorator (BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost(){
        int basePizzaCost = basePizza.getCost();
        return basePizzaCost + 10;
    }
}
