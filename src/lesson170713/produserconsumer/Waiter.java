package lesson170713.produserconsumer;

import lesson170310.Utils;

import java.util.concurrent.BlockingQueue;

/**
 * Created by User on 19.07.2017.
 */
class Waiter implements Runnable {
    private BlockingQueue<String> window;

    public Waiter(BlockingQueue<String> window) {
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start waiting");

            try {
                String dish = window.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("serving");
            Utils.pause(2000 + SynchQueueExample.random.nextInt(3000));
        }
    }
}
