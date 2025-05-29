package src.main.java.designPatterns.decorator.notification;

//Component interface that is extended by the wrappee and the decorators
public interface Notifier {
    public void sendMessage(String message);
}
