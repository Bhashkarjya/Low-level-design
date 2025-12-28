package behavioral.observer.subscribers;

public class TradingBotObserver implements Observer {
    @Override
    public void updatePrice(String name, int price) {
        System.out.println("Trading bot receives the price of " + name + " : " + price);
    }
}
