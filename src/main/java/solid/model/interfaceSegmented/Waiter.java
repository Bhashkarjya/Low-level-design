package src.main.java.solid.model.interfaceSegmented;

public class Waiter implements WaiterInterface {
    @Override
    public void serveFood() {
        System.out.println("Serving Food");
    }

    @Override
    public void takeOrder() {
        System.out.println("Taking orders");
    }
}
