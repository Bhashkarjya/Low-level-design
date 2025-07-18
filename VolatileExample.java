/* Implement a boolean flag using volatile to signal multiple worker threads to stop processing
    Implementation using managed thread pools
*/

/* Notes -
1. Visibility Problems
Without volatile, changes made to flag by one thread may not be immediately visible to other threads.

CPU cores and compiler optimizations may keep a cached copy of flag in each thread’s context.

When the main thread updates flag = false;, worker threads could continue reading the old value (true) and
keep running indefinitely (busy-waiting in their loop), even though the main thread thinks they should be stopping.
 */

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;
public class VolatileExample {
    private static volatile boolean flag = true;

    public static class MyThread extends Thread{
        @Override
        public void run() {
            while(flag) {
                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(Thread.currentThread().getName() + " is exiting");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int threadCount = 1000;
        List<Thread> workers = new ArrayList<Thread>(threadCount);
        for(int i = 0;i < threadCount; i++) {
            Thread t = new Thread(new MyThread());
            workers.add(t);
            t.start();
        }

        TimeUnit.SECONDS.sleep(1);
        flag = false;

        System.out.println("Setting flag to false. Waiting for the threads to stop execution");

        // Wait for all the threads to stop execution. If it is a daemon thread, JVM will exit without waiting for the daemon
        // thread's exeution to get over.
        for(Thread t : workers)
            t.join();
        System.out.println("All threads stopped gracefully");
    }
}
