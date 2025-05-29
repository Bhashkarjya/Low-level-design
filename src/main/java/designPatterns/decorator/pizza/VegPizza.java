package src.main.java.designPatterns.decorator.pizza;

//Concrete component class. This is the wrappee.
public class VegPizza extends BasePizza {
    int cost;

    public VegPizza (int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost(){
        return this.cost;
    }
}
