package fizzBuzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        executors.submit(new PrintFizz(fizzBuzz));
        executors.submit(new PrintBuzz(fizzBuzz));
        executors.submit(new PrintFizzBuzz(fizzBuzz));
        executors.submit(new PrintNumber(fizzBuzz));

        executors.shutdown();
        try {
            if(!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
