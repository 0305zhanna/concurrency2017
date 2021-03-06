package lesson170718.Homework.blockingqueue;

import lesson170310.Utils;
import lesson170713.WorkerThreadWithBlockingQueue;

/**
 * Created by User on 13.07.2017.
 */
public class UseWorkerWithBlockingQueue {
    static class Task implements Runnable{

        private int number;
        public Task(int number){
            this.number=number;
        }
        @Override
        public void run() {
            System.out.println("start"+number);
            Utils.pause(2000);
            System.out.println("stop"+number);
        }
    }
    public static void main(String[] args) {
       lesson170713.WorkerThreadWithBlockingQueue worker = new WorkerThreadWithBlockingQueue();

        worker.submit(new Task(1));
        worker.submit(new Task(2));
        worker.submit(new Task(3));
        worker.shutdown();
        System.out.println("finished task planning");
    }
}
