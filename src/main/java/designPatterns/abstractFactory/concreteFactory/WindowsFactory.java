package src.main.java.designPatterns.abstractFactory.concreteFactory;

import src.main.java.designPatterns.abstractFactory.Button;
import src.main.java.designPatterns.abstractFactory.Checkbox;
import src.main.java.designPatterns.abstractFactory.button.WindowsButton;
import src.main.java.designPatterns.abstractFactory.checkbox.GUIFactory;
import src.main.java.designPatterns.abstractFactory.checkbox.WindowsCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
