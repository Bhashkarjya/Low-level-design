
public class BankAccount {
    private final String accountHolderName;
    private int amount;
    private final int accountNumber;

    public BankAccount(String name, int accountNumber) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() { return this.accountHolderName; }
    public int getAccountNumber() { return this.accountNumber; }

    public synchronized int getAmount() {
        return this.amount;
    }

    public synchronized void withdraw(int amountToBeWithdrawn) {
        this.amount -= amountToBeWithdrawn;
    }

    public synchronized void deposit(int amountToBeDeposited) {
        this.amount += amountToBeDeposited;
    }

}
