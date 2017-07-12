package lesson170711;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 12.07.2017.
 */
public class WorkerThread {

    private Queue<Runnable> tasks = new LinkedList<>();

    public WorkerThread(){
        new Thread(this::process).start();
    }

    private void process(){
        while (true){
            Runnable task = null;
            synchronized (tasks){
                while (tasks.isEmpty()){
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                task = tasks.poll();
            }
            task.run();
        }
    }

    public void submit(Runnable task){
        synchronized (tasks){

            tasks.add(task);
            tasks.notify();

        }
    }

}
