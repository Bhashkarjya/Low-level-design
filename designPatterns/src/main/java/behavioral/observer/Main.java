package behavioral.observer;

import behavioral.observer.publisher.Publisher;
import behavioral.observer.publisher.StockPricePublisher;
import behavioral.observer.subscribers.AnalyticsObserver;
import behavioral.observer.subscribers.MobileAppObserver;
import behavioral.observer.subscribers.Observer;
import behavioral.observer.subscribers.TradingBotObserver;

public class Main {
    public static void main(String[] args) {

        //Create an instance of the Publisher class
        Publisher publisher = new StockPricePublisher();

        //Create different observers
        Observer mobileAppObserver = new MobileAppObserver();
        Observer analyticsObserver = new AnalyticsObserver();
        Observer tradingBotObserver = new TradingBotObserver();

        //Add the 3 observers to the list of the subscribers in the publisher
        publisher.addObserver(mobileAppObserver);
        publisher.addObserver(analyticsObserver);
        publisher.addObserver(tradingBotObserver);

        //Update the value of a stock to trigger a notification to all the observers
        publisher.updateStockPrice("GOOGLE", 305);

        //Remove a subscriber
        publisher.removeObserver(tradingBotObserver);

    }
}
