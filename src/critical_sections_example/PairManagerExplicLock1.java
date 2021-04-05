package critical_sections_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PairManagerExplicLock1 extends PairManager {
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }

    public  Pair getPair() {
        lock.lock();
        try {
        return new Pair(p.getX(), p.getY());
        } finally {
            lock.unlock();
        }
    }
}
