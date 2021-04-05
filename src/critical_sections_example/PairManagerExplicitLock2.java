package critical_sections_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PairManagerExplicitLock2 extends PairManager {
    private Lock lock = new ReentrantLock();

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }

    public Pair getPair() {
        lock.lock();
        try {
            return new Pair(p.getX(), p.getY());
        } finally {
            lock.unlock();
        }
    }
}
