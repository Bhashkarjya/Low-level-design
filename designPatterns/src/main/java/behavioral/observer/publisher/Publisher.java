package behavioral.observer.publisher;

import behavioral.observer.subscribers.Observer;

public interface Publisher {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(String name, int price);
    public void updateStockPrice(String name, int price);
}
