package src.main.java.designPatterns.decorator.notification;

public class FacebookNotifier implements Notifier {
    private Notifier notifier;
    private String faceBookId;

    public FacebookNotifier (Notifier notifier, String facebookId) {
        this.faceBookId = facebookId;
        this.notifier = notifier;
    }

    @Override
    public void sendMessage(String message) {
        notifier.sendMessage(message);
        System.out.println("Send the message : " + message + " to facebookId : " + faceBookId);
    }
}
