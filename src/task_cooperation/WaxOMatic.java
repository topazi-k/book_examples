package task_cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new WaxOn(car));
        executor.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }
}
