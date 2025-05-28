package src.main.java.designPatterns.observer.observer;

public class TextNotificationObserver implements Observer{
    private String phoneNumber;

    public TextNotificationObserver(String number) {
        this.phoneNumber = number;
    }
    @Override
    public void update(String productType) {
        System.out.println("Sent a text notification to " + this.phoneNumber);
        System.out.println("We have refreshed the stock of " + productType + " in our inventory");
    }
}
