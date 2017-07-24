package lesson170720;

import lesson170310.Utils;

import java.util.concurrent.Semaphore;

/**
 * Created by User on 24.07.2017.
 */
public class SemaphoreExamples {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(0);
        Runnable runner = () -> {
            System.out.println("waiting for signal");
            sem.acquireUninterruptibly();
            System.out.println("got signal");
            int count = 0;
            while (true){
                System.out.println(count++);
                Utils.pause(1000);
            }
        };
        new Thread(runner).start();
        Utils.pause(500);

        System.out.println("ready...");
        Utils.pause(1000);
        System.out.println("steady...");
        Utils.pause(1000);
        System.out.println("Go!");
        Utils.pause(1000);

        sem.release();
    }

}
