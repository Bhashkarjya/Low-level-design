import src.main.java.concurrency.synchronizedExamples.BankAccount;
import src.main.java.concurrency.synchronizedExamples.BankAccountSynchronized;

/* ReentrantReadWriteLock > Synchronized
 */

/* Time taken after using BankAccount class methods  (using ReentrantReadWriteLock) is around 70-80 ms and
   time taken after using BankAccountSynchronized class methods is around 250 ms.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PerformanceBenchmarkTest {

    public static void main(String[] args) throws InterruptedException{
        BankAccount account = new BankAccount("XYZ", "123456");
//        BankAccountSynchronized account = new BankAccountSynchronized("XYZ", "123456");
        int threadCount = 100;
        int repeatitions = 100;

        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        List<Runnable> threads = new ArrayList<>();

        for(int i = 0; i < threadCount; i++) {
            threads.add(() -> {
                for(int k = 0;k < repeatitions;k++) {
                    if(k % 2 == 0) {
                        account.deposit(100);
                        account.withdraw(100);
                    }
                    else {
                        account.getAmount();
                    }
                }
            });
        }

        long startTime = System.nanoTime();

        for(Runnable task : threads)
            exec.submit(task);

        exec.shutdown();

        if(!exec.awaitTermination(1, TimeUnit.SECONDS)) {
            exec.shutdownNow();
        }

        long endTime = System.nanoTime();

        long timeTaken = (endTime - startTime) / 1000000;
        System.out.println("Time taken = " + timeTaken);
        System.out.println("Final amount = " + account.getAmount());
    }
}
