package interruption;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream in){this.in =in;}

    public void run(){
        try{
            System.out.println("Waiting for read():");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from bockedIO");
            }else{
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
