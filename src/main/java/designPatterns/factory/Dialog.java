package src.main.java.designPatterns.factory;

//Abstract factory method
public abstract class Dialog {
    private Button button;
    public abstract Button createButton();

    public void render() {
        // Create the product object
        button = createButton();
        //Now use the object to render the button
        button.render();
    }
}
