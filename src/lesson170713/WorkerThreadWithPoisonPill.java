package lesson170713;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 12.07.2017.
 */
public class WorkerThreadWithPoisonPill {

    private Queue<Runnable> tasks = new LinkedList<>();
    private Thread thread;
    volatile private boolean running;

    static final private Runnable POISONN_PILL=()->{};
//            new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    }

    public WorkerThreadWithPoisonPill(){
        synchronized (tasks) {
            thread = new Thread(this::process);
            thread.start();
            running = true;
        }
    }

    public void shutdown(){
        submit(POISONN_PILL);

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
            if(task == POISONN_PILL){
                System.out.println("I am dying");
                break;
            }
            task.run();
        }
    }

    public boolean submit(Runnable task){
        synchronized (tasks){
            if(!running){
                return false;
            }
            if(task==POISONN_PILL){
                running=false;
            }
            tasks.add(task);
            tasks.notify();

        }
        return true;
    }

}
