package rateLimiter.entities;

public class TokenBucket {
    private int tokens;
    private long lastRefillTimestamp;

    public TokenBucket(int capacity) {
        this.tokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public int getTokens() { return this.tokens; }
    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
    public long getLastRefillTimestamp() { return this.lastRefillTimestamp; }
    public void setLastRefillTimestamp(long timeInMillis) {
        this.lastRefillTimestamp = timeInMillis;
    }
}
