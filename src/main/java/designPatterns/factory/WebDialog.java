package src.main.java.designPatterns.factory;

//Windows dialog will product HTML buttons
public class WebDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
