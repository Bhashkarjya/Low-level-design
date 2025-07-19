/* Implementation of BankAccount using Synchronized */

package src.main.java.concurrency.synchronizedExamples;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccountSynchronized {
    private final String accountHolderName;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int amount = 1000;
    private final String accountNumber;

    public BankAccountSynchronized(String name, String accountNumber) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() { return this.accountHolderName; }
    public String getAccountNumber() { return this.accountNumber; }

    public synchronized int getAmount() {
        return this.amount;
    }

    public synchronized void withdraw(int amountToBeWithdrawn) {
        if(amountToBeWithdrawn <= this.amount) {
            this.amount -= amountToBeWithdrawn;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amountToBeWithdrawn);
            System.out.println(Thread.currentThread().getName() + " amount = " + this.amount);
        }
        else {
            System.out.println("Insufficient balance for withdrawal by " + Thread.currentThread().getName());
        }
    }

    public synchronized void deposit(int amountToBeDeposited) {
        this.amount += amountToBeDeposited;
        System.out.println(Thread.currentThread().getName() + " deposited " + amountToBeDeposited);
        System.out.println(Thread.currentThread().getName() + " amount = " + this.amount);
    }

}
