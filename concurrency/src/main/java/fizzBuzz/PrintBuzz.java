package fizzBuzz;

public class PrintBuzz implements Runnable {
    private final FizzBuzz instance;
    public PrintBuzz (FizzBuzz instance) {
        this.instance = instance;
    }
    @Override
    public void run(){
        try {
            this.instance.printBuzz();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
