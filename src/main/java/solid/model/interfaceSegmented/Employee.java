package src.main.java.solid.model.interfaceSegmented;

/*
If waiter and cook classes implements this interface, they would have to provide implementation for some methods which they are
not using. This would violate Interface Segmented Principle
*/ 
public interface Employee {
    void washDishes();
    void cookFood();
    void serveFood();
    void takeOrders();
}
