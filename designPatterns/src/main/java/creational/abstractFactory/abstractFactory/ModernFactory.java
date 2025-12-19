package creational.abstractFactory.abstractFactory;

import creational.abstractFactory.chair.*;
import creational.abstractFactory.sofa.*;

public class ModernFactory implements FurnitureFactory{
    @Override
    public Chair getChair() {
        return new ModernChair();
    }

    @Override
    public Sofa getSofa() {
        return new ModernSofa();
    }
}
