package creational.factory;

public class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("Start the car");
    }
    @Override
    public void stop() {
        System.out.println("Stop the car");
    }
}
