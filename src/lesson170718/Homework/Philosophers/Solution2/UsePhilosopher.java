package lesson170718.Homework.Philosophers.Solution2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 19.07.2017.
 */
public class UsePhilosopher {
    public static void main(String[] args) {
        System.out.println("start");

        Lock f1 = new ReentrantLock();
        Lock f2 = new ReentrantLock();
        Lock f3 = new ReentrantLock();
        Lock f4 = new ReentrantLock();
        Lock f5 = new ReentrantLock();

        new Thread(new Philosopher(f1,f2)).start();
        new Thread(new Philosopher(f2,f3)).start();
        new Thread(new Philosopher(f3,f4)).start();
        new Thread(new Philosopher(f4,f5)).start();
        new Thread(new Philosopher(f5,f1)).start();

    }
}
