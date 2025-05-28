package src.main.java.designPatterns.observer.observer;

public class EmailNotificationObserver implements Observer{
    
    private String emailId;
    public EmailNotificationObserver (String emailId) {
        this.emailId = emailId;
    }
    
    @Override
    public void update(String productType) {
        System.out.println("Sent an email to " + this.emailId);
        System.out.println("We have refreshed the stock of " + productType + " in our inventory");
    }
}
