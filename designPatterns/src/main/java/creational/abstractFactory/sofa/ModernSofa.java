package creational.abstractFactory.sofa;

public class ModernSofa implements Sofa{
    @Override
    public void sofaType() {
        System.out.println("It is a Modern sofa");
    }

    @Override
    public int getCost() {
        return 100;
    }
}
