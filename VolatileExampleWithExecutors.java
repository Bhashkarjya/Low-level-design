/* Implement a boolean flag using volatile to signal multiple worker threads to stop processing
    Implementation using ExecutorService.
*/


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class VolatileExampleWithExecutors {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException{
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors : " + threadCount);
        //CPU time taken for ForkJoinPool was slightly better than newFixedThreadPool
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for( int i = 0; i < threadCount; i++) {
            Runnable runnable = () -> {
                while(flag) {
                    try {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " is exiting ");
            };
            executorService.submit(runnable);
        }

        TimeUnit.SECONDS.sleep(1);
        flag = false;

        System.out.println("Setting flag to false. Waiting for threads to exit gracefully");
        executorService.shutdown();

        if(!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Forcing shutdown");
            executorService.shutdownNow();
        }
    }
}
