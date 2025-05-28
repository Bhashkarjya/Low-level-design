package src.main.java.designPatterns.observer.observable;

import java.util.Map;
import src.main.java.designPatterns.observer.observer.Observer;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

//Basc publisher class

public class StockManager {
    private Map<String, List<Observer>> listeners = new HashMap<>();
    private Map<String, Integer> stockCount = new HashMap<>();

    public StockManager(String... products) {
        for(String product : products) {
            this.listeners.put(product, new ArrayList<>());
            this.stockCount.put(product, 0);
        }
    }

    private List<Observer> getSubscribersList(String productType) {
        return this.listeners.get(productType);
    }

    public void subscribe(String productType, Observer observer) {
        List<Observer> subscribersList = getSubscribersList(productType);
        subscribersList.add(observer);
    }

    public void unsubscribe(String productType, Observer observer) {
        List<Observer> subscribersList = getSubscribersList(productType);
        subscribersList.remove(observer);
    }

    public void notifySubscribers(String productType) {
        List<Observer> subscribersList = getSubscribersList(productType);
        for(Observer observer : subscribersList) {
            observer.update(productType);
        }
    }

    public void setStockCount(String productType, int count) {
        int currentStockCount = stockCount.get(productType);

        //notify the listeners when the stock has been refreshed
        if(currentStockCount == 0) {
            notifySubscribers(productType);
        }

        stockCount.put(productType, count);
    }

    public int getStockCount(String product) {
        return this.stockCount.get(product);
    }
}
