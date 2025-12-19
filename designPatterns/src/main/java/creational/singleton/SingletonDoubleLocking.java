package creational.singleton;

public class SingletonDoubleLocking {
    private static SingletonDoubleLocking instance;
    private String value;
    private SingletonDoubleLocking(String value) {
        this.value = value;
    }

    public static SingletonDoubleLocking getInstance(String value) {
        if (instance == null) {
            synchronized (SingletonDoubleLocking.class) {
                if(instance == null) {
                    instance = new SingletonDoubleLocking(value);
                }
                return instance;
            }
        }
        return instance;
    }

    public String getValue() {
        return this.value;
    }

}
