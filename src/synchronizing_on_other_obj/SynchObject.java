package synchronizing_on_other_obj;

public class SynchObject {
    public static void main(String[] args) {
        final DualSuch ds =new DualSuch();
        new Thread(ds::f).start();
        ds.g();
    }
}
