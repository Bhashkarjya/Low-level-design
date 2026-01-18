package rateLimiter.store;

import java.util.HashMap;
import java.util.Map;
public class DistributedStore implements DistributedStoreInterface {

    private Map<String, Object> store = new HashMap<>();
    @Override
    public synchronized Object get(String key) {
        return store.get(key);
    }

    @Override
    public void put(String key, Object value) {
        store.put(key, value);
    }
}
