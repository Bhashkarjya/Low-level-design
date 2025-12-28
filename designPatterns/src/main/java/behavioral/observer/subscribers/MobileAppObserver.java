package behavioral.observer.subscribers;

public class MobileAppObserver implements Observer {
    @Override
    public void updatePrice(String name, int price) {
        System.out.println("Update the price of " + name + " : " + price + " in the Mobile App");
    }
}
