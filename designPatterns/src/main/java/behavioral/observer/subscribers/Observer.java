package behavioral.observer.subscribers;

public interface Observer {
    public void updatePrice(String stockName, int stockPrice);
}
