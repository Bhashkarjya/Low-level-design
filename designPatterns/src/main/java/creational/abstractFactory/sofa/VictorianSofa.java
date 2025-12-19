package creational.abstractFactory.sofa;

public class VictorianSofa implements Sofa{
    @Override
    public void sofaType() {
        System.out.println("It is a Victorian sofa");
    }

    @Override
    public int getCost() {
        return 200;
    }
}
