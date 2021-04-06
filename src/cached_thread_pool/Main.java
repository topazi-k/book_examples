package cached_thread_pool;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        List<Integer> list = m.createData();
        List<List<Integer>> listsToExecute = ListUtils.partition(list, list.size()/15 + 1);
        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<Future> futures = new ArrayList<>();
        for (List<Integer> l : listsToExecute) {
            System.out.println(l.size());
           // futures.add(exec.submit(new MyTask(l)));
        }


//        for (Future f : futures) {
//            try {
//                f.get();
//            } catch (Exception e) {
//            }
//        }
//       int i = 0;
//        while (!isFinished(futures)) {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("still work");
//            }catch (InterruptedException e){}
//            if(i==3) MyTask.canceled =true;
//            i++;
//        }
        System.out.println("finish");
        exec.shutdown();

    }

    private static boolean isFinished(List<Future> futures) {
        for (Future f : futures) {
            if (!f.isDone()) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> createData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12320; i++) {
            list.add(i);
        }
        return list;
    }

    public static class MyTask implements Runnable {
        public static boolean canceled = false;
        private List<Integer> list;

        public MyTask(List<Integer> list) {
            this.list = list;
        }

        public void run() {
            for (int i : list) {
                System.out.println(i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                }
                if (canceled) return;
            }
        }
    }
}
