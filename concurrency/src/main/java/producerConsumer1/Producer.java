package producerConsumer1;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    //queue is the shared resource. Mark the queue as final so that reference is final and the queue can be assigned only once in the
    //constructor
    private static final int POISON_PILL = -1;
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            for(int i=1;i<=5;i++) {
                this.queue.put(i); //thread is blocked and enters the waiting state if the queue is full
                System.out.println("Produced : " + i);
                Thread.sleep(500);
            }
            /*
            Put the poison pill to indicate that the producer is done with producing new events
             */
            this.queue.put(POISON_PILL);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
