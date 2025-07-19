import src.main.java.concurrency.synchronizedExamples.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException{
        BankAccount account = new BankAccount("ABC", "123456" );

        /*
        Create three threads. Two threads will deposit money and one thread will withdraw money from the bank account
         */
        ExecutorService exec = Executors.newFixedThreadPool(50);
        Runnable depositMoneyThread = () -> {
            account.deposit(200);
        };

        Runnable withdrawMoneyThread = () -> {
            account.withdraw(100);
        };

        Runnable readBalance = () -> System.out.println(Thread.currentThread().getName() + "-> amount = " + account.getAmount());

        for(int i=0;i<20;i++)
            exec.submit(depositMoneyThread);

        for(int i=0;i<20;i++)
            exec.submit(withdrawMoneyThread);

        for(int i=0;i<10;i++)
            exec.submit(readBalance);

        exec.shutdown();

        if(!exec.awaitTermination(2, TimeUnit.SECONDS)) {
            exec.shutdownNow();
        }
    }
}
