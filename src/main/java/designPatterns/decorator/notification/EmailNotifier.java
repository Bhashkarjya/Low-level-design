package src.main.java.designPatterns.decorator.notification;

// This is the class that is getting wrapped
public class EmailNotifier implements Notifier{
    private String emailId;
    
    public EmailNotifier(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Send the message : " + message + " to the email address " + emailId);
    }
}
