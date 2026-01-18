package rateLimiter.config;

public class RateLimiterConfig {
    //Properties of token bucket
    private final int capacity;
    private final int refillRatePerSecond;

    //properties of SlidingWindow
    private final int maxRequests;
    private final long windowInMillis;

    public RateLimiterConfig(int capacity, int refillRatePerSecond, int maxRequests, long windowInMillis) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.maxRequests = maxRequests;
        this.windowInMillis = windowInMillis;
    }

    public int getCapacity() { return this.capacity;}
    public int getRefillRatePerSecond() { return this.refillRatePerSecond;}
    public int getMaxRequests() {return this.maxRequests;}
    public long getWindowInMillis() {return this.windowInMillis; }
}
