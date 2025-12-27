package orderingThreads;

import java.util.concurrent.Semaphore;

public class PrintValues {
    private final Semaphore second;
    private final Semaphore third;

    public PrintValues() {
        this.second = new Semaphore(0);
        this.third = new Semaphore(0);
    }
    public void first() {
        System.out.println("First");
        this.second.release();
    }

    public void second() {
        try {
            this.second.acquire();
            System.out.println("Second");
            this.third.release();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void third() {
        try {
            this.third.acquire();
            System.out.println("Third");
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
