package orderingThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        PrintValues print = new PrintValues();
        ExecutorService executors = Executors.newFixedThreadPool(3);
        executors.submit(print::first);
        executors.submit(print::second);
        executors.submit(print::third);

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
