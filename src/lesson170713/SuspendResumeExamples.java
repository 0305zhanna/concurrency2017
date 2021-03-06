package lesson170713;

import lesson170310.Utils;

/**
 * Created by User on 13.07.2017.
 */
public class SuspendResumeExamples {
    public static void main(String[] args) {
        System.out.println("start");

        Object lock = new Object();

        Thread thread = new Thread(()->{
            synchronized (lock){
                Utils.pause(10000);
                System.out.println("woke up");
            }
        });
        thread.start();

        Utils.pause(1000);

//        thread.suspend();

//        thread.resume();

    }
}
