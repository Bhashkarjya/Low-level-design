package src.main.java.designPatterns.abstractFactory.checkbox;

import src.main.java.designPatterns.abstractFactory.Checkbox;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("You have created a Windows Checkbox");
    }
}
