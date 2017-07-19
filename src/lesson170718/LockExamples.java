package lesson170718;

import lesson170310.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 19.07.2017.
 */
public class LockExamples {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(()->{
            lock.lock();  //synchronized(lock){
            try{
                Utils.pause(5000);
            }finally {
                lock.unlock(); // }
            }
        }).start();

        System.out.println("start");
        Utils.pause(1000);
        System.out.println("try to enter");

        lock.lock();  //synchronized(lock){
        try{
            System.out.println("got it!");
        }finally {
            lock.unlock(); // }
        }
    }

}
