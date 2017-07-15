package lesson170713;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 12.07.2017.
 */
public class WorkerThreadWithShutdown {

    private Queue<Runnable> tasks = new LinkedList<>();
    private Thread thread;

    public WorkerThreadWithShutdown(){
        new Thread(this::process).start();
    }

    public void shutdown(){
//        thread.stop();BAD
        thread.interrupt();
    }
    private void process(){
        OUTER: while (true){
            Runnable task = null;
            synchronized (tasks){
                while (tasks.isEmpty()){
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break OUTER;
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
