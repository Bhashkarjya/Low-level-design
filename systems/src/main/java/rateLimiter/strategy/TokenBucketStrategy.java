package rateLimiter.strategy;

import rateLimiter.config.RateLimiterConfig;
import rateLimiter.entities.TokenBucket;
import rateLimiter.store.DistributedStoreInterface;

import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketStrategy implements RateLimiterStrategy {
    private final ReentrantLock lock = new ReentrantLock();
    private final DistributedStoreInterface store;
    public TokenBucketStrategy(DistributedStoreInterface store) {
        this.store = store;
    }
    @Override
    public boolean allow(String clientName, String apiName, RateLimiterConfig config) {
        lock.lock();
        try{
            String key = clientName + ":" + apiName;
            TokenBucket bucket = (TokenBucket) store.get(key);
            long now = System.currentTimeMillis();

            if(bucket == null) {
                bucket = new TokenBucket(config.getCapacity());
                store.put(key, bucket);
            }

            long elapsedSeconds = now - bucket.getLastRefillTimestamp();

            if(elapsedSeconds > 0) {
                int refill = (int) (elapsedSeconds * config.getRefillRatePerSecond());
                bucket.setTokens(Math.min(config.getCapacity(), bucket.getTokens()) + refill);
                bucket.setLastRefillTimestamp(now);
            }

            if(bucket.getTokens() > 0) {
                bucket.setTokens(bucket.getTokens() - 1);
                store.put(key, bucket);
                System.out.println("Token bucket : API request is allowed");
                return true;
            }
            System.out.println("Token bucket : API request is not allowed");
            return false;
        }
        finally {
            lock.unlock();
        }

    }
}
