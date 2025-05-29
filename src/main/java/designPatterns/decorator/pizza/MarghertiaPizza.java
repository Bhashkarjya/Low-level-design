package src.main.java.designPatterns.decorator.pizza;

//Concrete component class. This is the wrappee.
public class MarghertiaPizza extends BasePizza{
    int cost;

    public MarghertiaPizza (int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost(){
        return this.cost;
    }
}
