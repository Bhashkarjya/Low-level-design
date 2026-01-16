package splitwise.balance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    //mapping from the user to the amount he owes/owed
    private final Map<String, Double> userVsBalance;
    private double totalBalance;

    public BalanceSheet() {
        this.userVsBalance = new ConcurrentHashMap<>();
        this.totalBalance = 0;
    }

    public Map<String, Double> getBalanceSheet() {
        return this.userVsBalance;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    public void incrementBalance(double amount) { this.totalBalance += amount; }
    public void decrementBalance(double amount) { this.totalBalance -= amount; }

}
