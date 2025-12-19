package creational.abstractFactory.chair;

public class ModernChair implements Chair{
    @Override
    public void chairType() {
        System.out.println("It is a Modern Chair");
    }
    @Override
    public int getCost() {
        return 200;
    }
}
