package creational.abstractFactory.chair;

public class VictorianChair implements Chair {
    @Override
    public void chairType() {
        System.out.println("It is a Victorian chair");
    }

    @Override
    public int getCost() {
        return 100;
    }
}
