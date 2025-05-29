package src.main.java.designPatterns.abstractFactory.button;

import src.main.java.designPatterns.abstractFactory.Button;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("You have created a Windows button");
    }
}
