package fizzBuzz;

public class PrintFizzBuzz implements Runnable {
    private final FizzBuzz instance;
    public PrintFizzBuzz (FizzBuzz instance) {
        this.instance = instance;
    }
    @Override
    public void run(){
        try {
            this.instance.printFizzBuzz();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
