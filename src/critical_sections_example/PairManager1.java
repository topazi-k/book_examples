package critical_sections_example;

public class PairManager1 extends PairManager{
    public synchronized void increment(){
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
