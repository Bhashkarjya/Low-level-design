package producerConsumer2;

import java.util.Queue;
public class Producer implements Runnable {
    private static final int POISON_PILL = -1;
    private final SharedBuffer buffer;
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            for(int i=1;i<=5;i++) {
                this.buffer.produce(i);
                System.out.println("Producing : " + i);
                Thread.sleep(500);
            }
            this.buffer.produce(POISON_PILL);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
