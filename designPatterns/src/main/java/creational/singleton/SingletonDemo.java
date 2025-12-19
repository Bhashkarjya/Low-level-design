package creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Create an object of the Singleton class");
        Singleton singleton = Singleton.getInstance();
        SingletonLazyLoading lazyLoading = SingletonLazyLoading.getInstance("FOO");
        SingletonDoubleLocking singletonDL = SingletonDoubleLocking.getInstance("BAR");
        System.out.println(singletonDL);
        System.out.println(lazyLoading.getValue());
        System.out.println(singletonDL.getValue());
    }

}
