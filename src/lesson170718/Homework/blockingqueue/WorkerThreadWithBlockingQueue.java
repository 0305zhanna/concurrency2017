package lesson170718.Homework.blockingqueue;


/**
 * Created by User on 12.07.2017.
 */
public class WorkerThreadWithBlockingQueue {

    final private BlockingQueue<Runnable> tasks;
    final private Thread thread;
    volatile private boolean mayAcceptTasks;

    final private Runnable POISONN_PILL=()->{};


    public WorkerThreadWithBlockingQueue(){
        synchronized (POISONN_PILL) {
            tasks = new BlockingQueue<>();
            thread = new Thread(this::process);
            thread.start();
            mayAcceptTasks = true;
        }
    }

    public void shutdown(){
        submit(POISONN_PILL);

    }
    private void process(){
        while (true){
            Runnable task = tasks.take();
            if(task == POISONN_PILL){
                System.out.println("I am dying");
                break;
            }
            task.run();
        }
    }

    public boolean submit(Runnable task){
        synchronized (POISONN_PILL) {
            if (!mayAcceptTasks) {
                return false;
            }
            if (task == POISONN_PILL) {
                mayAcceptTasks = false;
            }
            tasks.put(task);
        }
        return true;
    }

}
