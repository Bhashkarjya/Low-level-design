package src.main.java.designPatterns.abstractFactory.button;

import src.main.java.designPatterns.abstractFactory.Button;

//Concrete product classes
public class MacOSButton implements Button{
    @Override
    public void paint() {
        System.out.println("Created a MacOS Button");
    }
}
