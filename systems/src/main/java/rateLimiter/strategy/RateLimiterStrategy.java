package rateLimiter.strategy;

import rateLimiter.config.RateLimiterConfig;

public interface RateLimiterStrategy {
    boolean allow(String clientKey, String apiName, RateLimiterConfig config);
}
