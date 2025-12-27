package producerConsumer2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Producer Consumer problem without using BlockingQueue
public class Demo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(3);
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(new Producer(buffer));
        executors.submit(new Consumer(buffer));

        executors.shutdown();
        try {
            if (!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                executors.shutdownNow();
                System.out.println("Shutdown all the threads forcefully");
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
