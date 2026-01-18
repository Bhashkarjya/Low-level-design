package rateLimiter.store;

public interface DistributedStoreInterface {
    Object get(String key);
    void put(String key, Object value);
}
