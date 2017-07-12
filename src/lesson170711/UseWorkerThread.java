package lesson170711;

import lesson170310.Utils;

/**
 * Created by User on 12.07.2017.
 */
public class UseWorkerThread {

    public static void main(String[] args) {
        WorkerThread worker = new WorkerThread();
        worker.submit(() -> {
            System.out.println("start"+Thread.currentThread());
            Utils.pause(1000);
            System.out.println("stop");
        });
        worker.submit(() -> {
            System.out.println("start"+Thread.currentThread());
            Utils.pause(1000);
            System.out.println("stop");
        });
        worker.submit(() -> {
            System.out.println("start"+Thread.currentThread());
            Utils.pause(1000);
            System.out.println("stop");
        });
    }

}
