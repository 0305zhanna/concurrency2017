package lesson170705.Homework.Solution1;

import lesson170310.Utils;

/**
 * Created by User on 07.07.2017.
 */
public class Philosopher implements Runnable {
    private Fork first;
    private Fork last;

    public Philosopher(Fork right, Fork left){
        if(right.getNumber()<left.getNumber()){
            this.first = right;
            this.last = left;
        }else {
            this.first = left;
            this.last = right;
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (first) {
                System.out.println("took first!" + Thread.currentThread().getName());
                Utils.pause(1000);
                synchronized (last) {
                    System.out.println("took last!" + Thread.currentThread().getName());
                    System.out.println("Now I can eat!" + Thread.currentThread().getName());
                    Utils.pause(6000);
                    System.out.println("Done! Time to think!" + Thread.currentThread().getName());
                }
            }
            Utils.pause(5000);
        }
    }
}
