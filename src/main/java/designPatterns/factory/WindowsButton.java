package src.main.java.designPatterns.factory;

//Another concrete products class
public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Windows button");
    }

    @Override
    public void onClick() {
        System.out.println("Clicking on Windows button");
        this.render();
    }
}
