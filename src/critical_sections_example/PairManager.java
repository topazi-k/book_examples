package critical_sections_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

abstract class PairManager {
    AtomicLong checkCounter = new AtomicLong(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList((new ArrayList<Pair>()));

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair pair){
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }catch (InterruptedException e){
        }
    }

    public abstract void increment();
}
