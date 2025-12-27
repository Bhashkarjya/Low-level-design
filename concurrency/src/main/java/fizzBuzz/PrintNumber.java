package fizzBuzz;

public class PrintNumber implements Runnable{
    private final FizzBuzz instance;
    public PrintNumber (FizzBuzz instance) {
        this.instance = instance;
    }
    @Override
    public void run(){
        try {
            this.instance.printNumber();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
