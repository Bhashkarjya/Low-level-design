package rateLimiter.strategy;

import rateLimiter.config.RateLimiterConfig;
import rateLimiter.store.DistributedStoreInterface;

import java.util.ArrayDeque;
import java.util.Deque;

import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowStrategy implements RateLimiterStrategy {
    private final ReentrantLock lock = new ReentrantLock();
    private final DistributedStoreInterface store;
    public SlidingWindowStrategy(DistributedStoreInterface store) {
        this.store = store;
    }
    @Override
    public boolean allow(String clientName, String apiName, RateLimiterConfig config) {
        lock.lock();
        try{
            String key = clientName + ":" + apiName;
            Deque<Long> timestamps = (Deque<Long>) this.store.get(key);
            long now = System.currentTimeMillis();

            if(timestamps == null) {
                timestamps = new ArrayDeque<>();
                store.put(key, timestamps);
            }

            while(!timestamps.isEmpty() && (now - timestamps.peekFirst()) > config.getWindowInMillis()) {
                timestamps.pollFirst();
            }

            if(timestamps.size() < config.getMaxRequests()) {
                System.out.println("Sliding Window : API request is allowed");
                timestamps.addLast(now);
                return true;
            }

            System.out.println("Sliding window : API request is not allowed");
            return false;
        } finally {
            lock.unlock();
        }
    }
}
