package src.main.java.designPatterns.factory;

// Concrete products class
public class HTMLButton implements Button{
    @Override
    public void render() {
        System.out.println("<button> HTML </button");
    }   
    
    @Override
    public void onClick() {
        System.out.println("Clicking an HTML button");
        this.render();
    }
}
