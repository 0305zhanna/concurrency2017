package lesson170718.Homework.Philosophers.Solution2;

import lesson170310.Utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by User on 07.07.2017.
 */
public class Philosopher implements Runnable {
    private Lock left;
    private Lock right;
    private boolean nothungry;

    public Philosopher(Lock right, Lock left){
        this.left = left;
        this.right = right;
        nothungry = false;
    }

    @Override
    public void run() {
        while (true) {

                right.lock();
                try{
                    System.out.println("took right!" + Thread.currentThread().getName());
//                    Utils.pause(1000);
                    if(left.tryLock(10000, TimeUnit.MILLISECONDS)){
                        try {
                            System.out.println("took left!" + Thread.currentThread().getName());
                            System.out.println("Now I can eat!" + Thread.currentThread().getName());
                            Utils.pause(6000);
                            System.out.println("Done! Now time to think!" + Thread.currentThread().getName());
                            nothungry = true;
                        }finally {
                            left.unlock();
                        }
                    }else{
                        System.out.println("Fork is busy"+Thread.currentThread().getName());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    right.unlock();
                }

            if(nothungry){
                Utils.pause(7000);
                nothungry = false;
            }

        }
    }
}
