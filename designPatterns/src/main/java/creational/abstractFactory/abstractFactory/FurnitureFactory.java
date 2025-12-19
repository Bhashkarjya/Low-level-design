package creational.abstractFactory.abstractFactory;

import creational.abstractFactory.sofa.Sofa;
import creational.abstractFactory.chair.Chair;
public interface FurnitureFactory {
    Chair getChair();
    Sofa getSofa();
}
