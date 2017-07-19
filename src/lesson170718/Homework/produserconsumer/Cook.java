package lesson170718.Homework.produserconsumer;

import lesson170310.Utils;

import java.util.concurrent.BlockingQueue;

/**
 * Created by User on 19.07.2017.
 */
class Cook implements Runnable {
    private BlockingQueue<String> window;

    public Cook(BlockingQueue<String> window) {
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start cooking");
            Utils.pause(1000 + SynchQueueExample.random.nextInt(3000));
            System.out.println("dish ready, waiting for waiter");
            try {
                window.put("dish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
