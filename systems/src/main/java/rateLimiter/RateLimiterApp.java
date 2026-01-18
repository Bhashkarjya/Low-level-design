package rateLimiter;

import rateLimiter.config.RateLimiterConfig;
import rateLimiter.store.DistributedStore;
import rateLimiter.store.DistributedStoreInterface;
import rateLimiter.strategy.RateLimiterStrategy;
import rateLimiter.strategy.StrategyFactory;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterApp {
    public static void main(String[] args) throws Exception{
        DistributedStoreInterface distributedStore = new DistributedStore();

        RateLimiterConfig config1 = new RateLimiterConfig(5, 3, 0, 0);
        RateLimiterConfig config2 = new RateLimiterConfig(0,0, 3, 10);
        Map<String, RateLimiterConfig> apiConfigs = new HashMap<>();
        apiConfigs.put("login", config1);
        apiConfigs.put("post", config2);

        RateLimiterStrategy tokenBucketStrategy = StrategyFactory.getTokenBucketStrategy(distributedStore);
        RateLimiterStrategy slidingWindowStrategy = StrategyFactory.getSlidingWindowStrategy(distributedStore);

        RateLimiterService service = RateLimiterService.getInstance(tokenBucketStrategy, apiConfigs);

        for(int i=0;i<10;i++) {
            service.allowRequest("Client1", "login");
        }

        //to simulate some time off so that we allow the tokens to refill
        Thread.sleep(2);
        for(int i=0;i<10;i++) {
            service.allowRequest("Client1", "login");
        }

    }
}
