import src.main.java.designPatterns.decorator.notification.EmailNotifier;
import src.main.java.designPatterns.decorator.notification.FacebookNotifier;
import src.main.java.designPatterns.decorator.notification.Notifier;
import src.main.java.designPatterns.decorator.notification.SlackNotifier;

public class DecoratorClient {
    public static void main(String[] args) {
        String message = "Your house is on fire";
        Notifier notifier = new EmailNotifier("xyz@gmail.com");

        boolean facebookEnabled = true;
        if(facebookEnabled) {
            notifier = new FacebookNotifier(notifier, "xyz");
        }

        boolean slackEnabled = true;
        if(slackEnabled) {
            notifier = new SlackNotifier(notifier, "xyz");
        }

        notifier.sendMessage(message);
    }
}