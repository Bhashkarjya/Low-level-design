package src.main.java.designPatterns.abstractFactory.checkbox;

import src.main.java.designPatterns.abstractFactory.Button;
import src.main.java.designPatterns.abstractFactory.Checkbox;

//Abstract factory
public interface GUIFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}
