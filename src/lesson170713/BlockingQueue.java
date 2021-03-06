package lesson170713;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 13.07.2017.
 */
public class BlockingQueue<T> {

    private Queue<T> tasks = new LinkedList<>();

    public void put(T item){
        synchronized (tasks){
            tasks.add(item);
            tasks.notify();
        }

    }

    public T take(){
        synchronized (tasks){
            while (tasks.isEmpty()){
                try {
                    tasks.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return tasks.poll();
        }

    }
}
