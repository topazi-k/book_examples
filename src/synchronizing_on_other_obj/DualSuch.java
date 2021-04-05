package synchronizing_on_other_obj;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class DualSuch {
    private Object synchObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){}
        }
    }

    public void g() {
        synchronized (/*this*/synchObject) {
            for (int i = 0; i < 5; i++){
                System.out.println("g()");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){}
            }
        }
    }
}
