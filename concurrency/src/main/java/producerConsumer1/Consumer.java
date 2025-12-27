package producerConsumer1;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    //queue is the shared resource. Mark the queue as final so that reference is final and the queue can be assigned only once in
    //the constructor
    private static final int POISON_PILL = -1;
    private final BlockingQueue<Integer> queue;
    public Consumer (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while(true) {
                Integer value = this.queue.take();//the thread gets blocked and enters waiting state if the queue is empty
                /*
                At this moment the consumer thread is blocked permanently once the producer thread stops producing.
                To overcome this we have two options :
                1. POISON_PILL : Producer puts a POISON_PILL in the queue. Once the consumer consumes the POISON_PILL, it will
                terminate the consumer thread. This approach is used when we know that the producer produces fixed number of items.
                */
                if(value == POISON_PILL) {
                    System.out.println("Consumed the POISON_PILL. Terminating the consumer thread");
                    break;
                }

                /*
                2. POLL WITH TIMEOUT : Consumer polls for a specific amount of time and it the time period is crossed, it will
                terminate the thread.

                Integer value1 = this.queue.poll(5, TimeUnit.SECONDS);
                if( value1 == null) {
                    System.out.println("Timeout exceeded for consuming new events. Terminating the consumer thread.");
                    break;
                }
                */
                System.out.println("Consumed : " + value);
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
