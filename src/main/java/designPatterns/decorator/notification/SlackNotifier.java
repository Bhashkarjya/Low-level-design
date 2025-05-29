package src.main.java.designPatterns.decorator.notification;

public class SlackNotifier implements Notifier {
    private Notifier notifier;
    private String slackId;

    public SlackNotifier (Notifier notifier, String slackId) {
        this.slackId = slackId;
        this.notifier = notifier;
    }
    
    @Override
    public void sendMessage(String message) {
        notifier.sendMessage(message);

        System.out.println("Send the message : " + message + " to slackId : " + slackId);
    }
}
