package src.main.java.designPatterns.abstractFactory.concreteFactory;

import src.main.java.designPatterns.abstractFactory.Button;
import src.main.java.designPatterns.abstractFactory.Checkbox;
import src.main.java.designPatterns.abstractFactory.button.MacOSButton;
import src.main.java.designPatterns.abstractFactory.checkbox.GUIFactory;
import src.main.java.designPatterns.abstractFactory.checkbox.MacOSCheckbox;

// Concrete factory classes
public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
