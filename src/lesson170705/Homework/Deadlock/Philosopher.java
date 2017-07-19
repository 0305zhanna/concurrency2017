package lesson170705.Homework.Deadlock;

import lesson170310.Utils;

/**
 * Created by User on 07.07.2017.
 */
public class Philosopher implements Runnable {
    private Fork left;
    private Fork right;

    public Philosopher(Fork right, Fork left){
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (right) {
                System.out.println("took right!" + Thread.currentThread().getName());
                Utils.pause(1000);
                synchronized (left) {
                    System.out.println("took left!" + Thread.currentThread().getName());
                    System.out.println("Now I can eat!" + Thread.currentThread().getName());
                    Utils.pause(6000);
                    System.out.println("Done! Time to think!" + Thread.currentThread().getName());
                }
            }
            Utils.pause(5000);
        }
    }
}
