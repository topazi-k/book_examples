package interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {
    private static ExecutorService exec =
            Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true); // Interrupts if running
        System.out.println("Interrupt sent to " + r.getClass().getName()+"\n");
    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        TimeUnit.SECONDS.sleep(2);
        test(new IOBlocked(System.in));
        TimeUnit.SECONDS.sleep(2);
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }
}
