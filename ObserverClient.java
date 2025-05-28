import src.main.java.designPatterns.observer.observable.Stock;
import src.main.java.designPatterns.observer.observer.EmailNotificationObserver;
import src.main.java.designPatterns.observer.observer.TextNotificationObserver;

public class ObserverClient {
    public static void main (String[] args) {

        Stock stock = new Stock ("Iphone", "Macbook");
        stock.getStockManager().subscribe("Iphone", new EmailNotificationObserver("xyz@gmail.com"));
        stock.getStockManager().subscribe("Iphone", new TextNotificationObserver("12345"));

        stock.getStockManager().subscribe("Macbook", new EmailNotificationObserver("abc@gmail.com"));
        stock.getStockManager().subscribe("Macbook", new TextNotificationObserver("78654"));

        stock.updateInventory("Iphone", 10);
        stock.updateInventory("Macbook", 15);
    }
}