package rateLimiter;

import rateLimiter.config.RateLimiterConfig;
import rateLimiter.strategy.RateLimiterStrategy;
import java.util.Map;
public class RateLimiterService {
    private static volatile RateLimiterService instance;
    private final RateLimiterStrategy strategy;
    private final Map<String, RateLimiterConfig> apiConfigs;

    private RateLimiterService(RateLimiterStrategy strategy, Map<String, RateLimiterConfig> apiConfigs) {
        this.strategy = strategy;
        this.apiConfigs = apiConfigs;
    }

    public static RateLimiterService getInstance(RateLimiterStrategy strategy, Map<String, RateLimiterConfig> apiConfigs) {
        if(instance == null) {
            synchronized (RateLimiterService.class) {
                if(instance == null) {
                    return new RateLimiterService(strategy, apiConfigs);
                }
            }
        }
        return instance;
    }

    public boolean allowRequest(String clientName, String apiName) {
        RateLimiterConfig config = apiConfigs.get(apiName);
        if(config == null) {
            System.out.println("No rate limiting in place. Allow requests to go through");
            return true;
        }
        return this.strategy.allow(clientName, apiName, config);
    }
}
