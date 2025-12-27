package rateLimiter;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucket {
    private int refillRate;
    private int capacity;
    private int tokenCount;
    private long lastRefillTimestampNanos;
    private final ReentrantLock lock = new ReentrantLock();
    public TokenBucket(int rate, int capacity) {
        this.refillRate = rate;
        this.capacity = capacity;
        this.tokenCount = this.capacity;
        this.lastRefillTimestampNanos = System.nanoTime();
    }

    public boolean consumeTokens() {
        this.lock.lock();
        try {
            refillTokens();
            if(this.tokenCount == 0) {
                return false;
            }
            this.tokenCount--;
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    public void refillTokens() {
        long now = System.nanoTime();
        long elapsedNanos = now - lastRefillTimestampNanos;

        if(elapsedNanos <= 0)
            return;
        long elapsedSeconds = TimeUnit.NANOSECONDS.toSeconds(elapsedNanos);
        if(elapsedSeconds <= 0)
            return;
        int tokensToAdd =(int)elapsedSeconds * this.refillRate;
        if(tokensToAdd > 0) {
            this.tokenCount = Math.min(this.tokenCount + tokensToAdd, this.capacity);
            this.lastRefillTimestampNanos += elapsedNanos;
        }
    }
}
