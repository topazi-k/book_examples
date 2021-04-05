package critical_sections_example;

public class PairManipulator implements Runnable{
    private PairManager pm;
    public PairManipulator (PairManager pm){
        this.pm = pm;
    }

    public void run(){
        while (true)
            pm.increment();
    }

    public String toString(){
        return "Pair: "+ pm.getPair() + " check counter = " + pm.checkCounter.get();
    }
}
