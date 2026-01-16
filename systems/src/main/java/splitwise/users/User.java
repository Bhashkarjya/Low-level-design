package splitwise.users;

import splitwise.balance.BalanceSheet;

import java.util.UUID;

public class User {
    private final String name;
    private final int userId;

    private final BalanceSheet userBalanceSheet;

    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID().hashCode();
        this.userBalanceSheet = new BalanceSheet();
    }

    public String getUserName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public BalanceSheet getBalanceSheet() {
        return this.userBalanceSheet;
    }
}
