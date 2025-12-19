package creational.abstractFactory.abstractFactory;

import creational.abstractFactory.chair.*;
import creational.abstractFactory.sofa.*;

public class VictorianFactory implements FurnitureFactory {
    @Override
    public Chair getChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa getSofa() {
        return new VictorianSofa();
    }
}
