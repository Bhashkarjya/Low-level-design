package counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger counter;
    public Counter (int defaultValue) {
        this.counter = new AtomicInteger(defaultValue);
    }

    public void incrementCounter() {
        this.counter.incrementAndGet();
    }

    public int readCounter() {
        return this.counter.get();
    }
}
