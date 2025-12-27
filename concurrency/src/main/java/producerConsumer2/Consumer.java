package producerConsumer2;

public class Consumer implements Runnable {
    private static final int POISON_PILL = -1;
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            while(true) {
                int value = this.buffer.consume();
                if(value == POISON_PILL) {
                    System.out.println("Consumed POISON PILL");
                    break;
                }
                System.out.println("Consumed : " + value);
            }
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
