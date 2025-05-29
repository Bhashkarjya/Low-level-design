package src.main.java.designPatterns.factory;

//Windows dialog will product Windows button
public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
