package lesson170711;

import lesson170310.Utils;

/**
 * Created by User on 12.07.2017.
 */
public class NaiveMessagePassing {

    volatile static boolean ready = false;

    static class Task implements Runnable{


        @Override
        public void run() {
            while (!ready){}
            System.out.println("got it!");
        }
    }

    public static void main(String[] args) {
        new Thread(new Task()).start();
        Utils.pause(30000);
        ready = true;
    }
}
