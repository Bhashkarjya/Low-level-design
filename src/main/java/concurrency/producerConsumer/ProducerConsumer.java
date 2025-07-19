package main.java.concurrency.producerConsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    private int producerCount;
    private int consumerCount;
    private int threadCount;
    private final SharedBuffer queue = new SharedBuffer();

    public ProducerConsumer(int producerCount, int consumerCount) {
        this.consumerCount = consumerCount;
        this.producerCount = producerCount;
        this.threadCount = this.consumerCount + this.producerCount;
    }

    private Runnable getProducerThread(){
        return () -> {
            int itemValue = new Random().nextInt();
            try {
                queue.addTask(itemValue);
                System.out.println(Thread.currentThread().getName() + " produced " + itemValue);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
    }

    private Runnable getConsumerThread() {
        return () -> {
            try {
                int item = queue.removeTask();
                System.out.println(Thread.currentThread().getName() + " consumed " + item);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
    }

    public void startExecution() throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(this.threadCount);

        System.out.println("Starting execution of producer workers");
        for( int i = 0; i < this.producerCount; i++) {
            exec.submit(getProducerThread());
        }

        System.out.println("Starting execution of consumer workers");
        for( int i = 0; i < this.consumerCount; i++) {
            exec.submit(getConsumerThread());
        }

        exec.shutdown();

        if(!exec.awaitTermination(2, TimeUnit.SECONDS)) {
            exec.shutdownNow();
        }
    }
}
