package lesson170720;

import lesson170310.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by User on 24.07.2017.
 */
public class SemaphoreFairExample {

    static volatile int count = 0;
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(0,true);


        List<Runner> runners = Arrays.asList(new Runner(sem),new Runner(sem),new Runner(sem),new Runner(sem));

        ExecutorService service = Executors.newCachedThreadPool();

        for (Runner runner :runners) {
            Utils.pause(200);
            service.execute(runner);
        }

        Utils.pause(500);

        System.out.println("ready...");
        Utils.pause(1000);
        System.out.println("steady...");
        Utils.pause(1000);
        System.out.println("Go!");
        Utils.pause(1000);

        for (int i = 0; i < runners.size(); i++) {
            sem.release();
            Utils.pause(100);
        }

    }

    private static class Runner implements Runnable {
        private final Semaphore sem;

        public Runner(Semaphore sem) {
            this.sem = sem;
        }

        @Override
        public void run() {
            int number = count++;
            System.out.println(number + "waiting for signal");
            sem.acquireUninterruptibly();
            System.out.println(number + "got signal");
        }
    }
}
