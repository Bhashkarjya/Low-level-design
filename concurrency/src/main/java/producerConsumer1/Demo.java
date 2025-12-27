package producerConsumer1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Producer Consumer Problem by using BlockingQueue
public class Demo {
    public static void main(String[] args) throws Exception {
        //shared queue of size 3
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        /*
        Creating the threads via ExecutorService
        */
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(new Producer(queue));
        executors.submit(new Consumer(queue));
        executors.shutdown();
        try {
            if(!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                executors.shutdownNow();
                System.out.println("Forcefully shutdown all the threads");
            }
        }
        catch (InterruptedException e) {
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }

        /*
        Creating threads directly
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
         */
    }
}
