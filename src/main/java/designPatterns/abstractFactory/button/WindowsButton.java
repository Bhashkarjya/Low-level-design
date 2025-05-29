package src.main.java.designPatterns.abstractFactory.button;

import src.main.java.designPatterns.abstractFactory.Button;

//Concrete product classes
public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("You have created a Windows button");
    }
}
