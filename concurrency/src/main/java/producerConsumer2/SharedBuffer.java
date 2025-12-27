package producerConsumer2;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> queue;
    private int capacity;
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>(capacity);
    }

    public synchronized void produce(int value) throws InterruptedException {
        while(this.queue.size() == this.capacity) {
            wait();
        }
        this.queue.offer(value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while(this.queue.isEmpty()) {
            wait();
        }
        int value = this.queue.poll();
        notifyAll();
        return value;
    }

}
