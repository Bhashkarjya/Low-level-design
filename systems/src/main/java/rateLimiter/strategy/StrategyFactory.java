package rateLimiter.strategy;

import rateLimiter.store.DistributedStore;
import rateLimiter.store.DistributedStoreInterface;

public class StrategyFactory {
    public static RateLimiterStrategy getTokenBucketStrategy(DistributedStoreInterface store) {
        return new TokenBucketStrategy(store);
    }

    public static RateLimiterStrategy getSlidingWindowStrategy(DistributedStoreInterface store) {
        return new SlidingWindowStrategy(store);
    }
}
