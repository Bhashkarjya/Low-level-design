package src.main.java.designPatterns.observer.observable;

import java.util.List;

// Concrete publisher class
public class Stock {
    private StockManager stockManager;

    public Stock (String... products) {
        this.stockManager = new StockManager(products);
    }

    public void updateInventory(String productType, int count) {
        stockManager.setStockCount(productType, count);
    }

    public StockManager getStockManager() {
        return this.stockManager;
    }
}
