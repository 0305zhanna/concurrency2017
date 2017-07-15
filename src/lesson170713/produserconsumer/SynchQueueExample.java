package lesson170713.produserconsumer;

import jdk.nashorn.internal.ir.Block;
import lesson170310.Utils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by User on 13.07.2017.
 */
public class SynchQueueExample {

    static final Random random = new Random();

    static class Cook implements Runnable{
        private BlockingQueue<String> window;

        public Cook(BlockingQueue<String> window) {
            this.window = window;
        }

        @Override
        public void run() {
            while(true){
                System.out.println("start cooking");
                Utils.pause(1000 + random.nextInt(3000));
                System.out.println("dish ready, waiting for waiter");
                try {
                    window.put("dish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Waiter implements Runnable {
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
                Utils.pause(2000 + random.nextInt(3000));
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<String> window = new LinkedBlockingQueue<>();

        Cook cook = new Cook(window);

        Waiter waiter = new Waiter(window);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(cook);
        service.execute(waiter);

        service.execute(() ->{
            while (true){
                Utils.pause(1000);
                System.out.println(window.size());
                if(window.size()>2) {
                    service.execute(new Waiter(window));
                }
            }
        });
    }
}
