package lesson170711;

/**
 * Created by User on 12.07.2017.
 */
public class SimpleWorker {

    public void process(Runnable task){
        new Thread(task).start();
    }

}
