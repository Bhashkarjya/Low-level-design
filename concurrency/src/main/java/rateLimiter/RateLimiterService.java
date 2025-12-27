package rateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RateLimiterService {
    private static final int REFILL_RATE = 2;
    private static final int CAPACITY = 4;

    private final TokenBucket tokenBucket;
    public RateLimiterService () {
        this.tokenBucket = new TokenBucket(REFILL_RATE, CAPACITY);
    }

    public boolean isAllowed() {
        return this.tokenBucket.consumeTokens();
    }
}
