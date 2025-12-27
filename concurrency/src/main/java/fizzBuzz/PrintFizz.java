package fizzBuzz;

public class PrintFizz implements Runnable {
    private final FizzBuzz instance;
    public PrintFizz (FizzBuzz instance) {
        this.instance = instance;
    }
    @Override
    public void run(){
        try {
            this.instance.printFizz();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
