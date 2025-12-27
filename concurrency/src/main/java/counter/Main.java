package counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(0);
        ExecutorService executors = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++) {
            executors.submit(() -> {
                counter.incrementCounter();
                System.out.println("Counter : " + counter.readCounter());
            });
        }

        executors.shutdown();

        try {
            if (!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
