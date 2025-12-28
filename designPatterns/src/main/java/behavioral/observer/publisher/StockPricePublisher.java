package behavioral.observer.publisher;

import behavioral.observer.subscribers.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class StockPricePublisher implements Publisher {
    private final Map<String, Integer> stockPrices;
    private final List<Observer> observers;

    public StockPricePublisher() {
        this.stockPrices = new HashMap<>();
        this.observers = new ArrayList<>();
        populateStockPrices();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String name, int price) {
        for(Observer observer : this.observers) {
            observer.updatePrice(name, price);
        }
    }

    //This method is called by a third party service in real time which updates the value of a stock
    @Override
    public void updateStockPrice(String name, int price) {
        this.stockPrices.put(name, price);
        notifyObservers(name, price);
    }

    private void populateStockPrices() {
        this.stockPrices.put("GOOGLE", 300);
        this.stockPrices.put("ORCL", 200);
        this.stockPrices.put("TESLA", 450);
    }
}
