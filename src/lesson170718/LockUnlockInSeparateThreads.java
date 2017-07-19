package lesson170718;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 19.07.2017.
 */
public class LockUnlockInSeparateThreads {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        System.out.println(lock.getHoldCount());

        lock.lock();
        System.out.println(lock.getHoldCount());

        new Thread(()->{
            if(lock.isHeldByCurrentThread()){
            lock.unlock();
            }else {
                System.out.println("I can't do it!");
            }
        }).start();

    }

}
