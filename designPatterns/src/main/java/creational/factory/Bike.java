package creational.factory;

public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Start the bike");
    }
    @Override
    public void stop() {
        System.out.println("Stop the bike");
    }
}
