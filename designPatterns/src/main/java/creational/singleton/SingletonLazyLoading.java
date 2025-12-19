package creational.singleton;

public class SingletonLazyLoading {
    private static SingletonLazyLoading instance;
    private String value;
    private SingletonLazyLoading(String value) {
        this.value = value;
    }

    public static SingletonLazyLoading getInstance (String value) {
        if(instance == null) {
            instance = new SingletonLazyLoading(value);
        }
        return instance;
    }

    public String getValue() {
        return this.value;
    }
}
