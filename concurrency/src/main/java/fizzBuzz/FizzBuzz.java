package fizzBuzz;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
    private int n;
    private Semaphore numberSemaphore;
    private Semaphore fizzSemaphore;
    private Semaphore buzzSemaphore;
    private Semaphore fizzBuzzSemaphore;

    public FizzBuzz(int n) {
        this.n = n;
        this.numberSemaphore = new Semaphore(1);
        this.fizzSemaphore = new Semaphore(0);
        this.buzzSemaphore = new Semaphore(0);
        this.fizzBuzzSemaphore = new Semaphore(0);
    }

    public void printFizz() throws InterruptedException {
        for(int i = 1 ; i <= this.n; i++) {
            if( i % 3 == 0 && i % 5 != 0) {
                this.fizzSemaphore.acquire();
                System.out.println("fizz");
                this.numberSemaphore.release();
            }
        }
    }

    public void printBuzz() throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if( i % 5 == 0 && i % 3 != 0) {
                this.buzzSemaphore.acquire();
                System.out.println("buzz");
                this.numberSemaphore.release();
            }
        }
    }

    public void printFizzBuzz() throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if( i % 5 == 0 && i % 3 == 0) {
                this.fizzBuzzSemaphore.acquire();
                System.out.println("fizzbuzz");
                this.numberSemaphore.release();
            }
        }
    }

    public void printNumber() throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            this.numberSemaphore.acquire();
            if( i % 3 == 0 && i % 5 == 0) {
                this.fizzBuzzSemaphore.release();
            }
            else if ( i % 3 == 0) {
                this.fizzSemaphore.release();
            }
            else if ( i % 5 == 0) {
                this.buzzSemaphore.release();
            }
            else {
                System.out.println(i);
                this.numberSemaphore.release();
            }
        }
    }




}
