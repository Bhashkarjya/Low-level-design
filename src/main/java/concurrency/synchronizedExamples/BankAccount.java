/* Implementation of BankAccount using ReentrantLock */

package src.main.java.concurrency.synchronizedExamples;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private final String accountHolderName;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int amount = 1000;
    private final String accountNumber;

    public BankAccount(String name, String accountNumber) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() { return this.accountHolderName; }
    public String getAccountNumber() { return this.accountNumber; }

    public int getAmount() {
        this.lock.readLock().lock();
        try {
            return this.amount;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void withdraw(int amountToBeWithdrawn) {
        lock.writeLock().lock();
        try {
            if(amountToBeWithdrawn <= this.amount) {
                this.amount -= amountToBeWithdrawn;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amountToBeWithdrawn);
                System.out.println(Thread.currentThread().getName() + " amount = " + this.amount);
            }
            else {
                System.out.println("Insufficient balance for withdrawal by " + Thread.currentThread().getName());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deposit(int amountToBeDeposited) {
        lock.writeLock().lock();
        try {
            this.amount += amountToBeDeposited;
            System.out.println(Thread.currentThread().getName() + " deposited " + amountToBeDeposited);
            System.out.println(Thread.currentThread().getName() + " amount = " + this.amount);
        } finally {
            lock.writeLock().unlock();
        }

    }

}
