package lesson170718.Homework.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 13.07.2017.
 */
public class BlockingQueue<T> {

    final Lock lock = new ReentrantLock();

    Condition notEmty = lock.newCondition();

    private Queue<T> tasks = new LinkedList<>();

    public void put(T item){
        lock.lock();
        try{
            tasks.add(item);
            notEmty.signal();
        }finally {
            lock.unlock();
        }

    }

    public T take(){
        lock.lock();
        try{
            while (tasks.isEmpty()){
                try {
                    notEmty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return tasks.poll();
        } finally {
            lock.unlock();
        }
    }
}
