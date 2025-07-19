package main.java.concurrency.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private Queue<Integer> queue = new LinkedList<>();
    private static int sizeLimit = 10;

    public synchronized void addTask(int item) throws InterruptedException{
        while (queue.size() >= sizeLimit) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized int removeTask() throws InterruptedException{
        while(queue.isEmpty()) {
            wait();
        }
        int item = queue.remove();
        notifyAll();
        return item;
    }
}
