package behavioral.observer.subscribers;

public class AnalyticsObserver implements Observer {
    @Override
    public void updatePrice(String name, int price) {
        System.out.println("Record the price of " + name + " : " + price + " for analysis");
    }
}
