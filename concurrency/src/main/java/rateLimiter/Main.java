package rateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception{
        final RateLimiterService service = new RateLimiterService();
        ExecutorService executors = Executors.newFixedThreadPool(4);
        for(int i=0;i<40;i++) {
            executors.submit(() -> {
                if(service.isAllowed()) {
                    System.out.println("API request is allowed");
                } else {
                    System.out.println("API request is failed");
                }
            });
            Thread.sleep(5); // to simulate a gap between the start time of all the threads
        }

        executors.shutdown();

        try {
            if(!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                executors.shutdownNow();
                System.out.println("Shutting down all the threads");
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
