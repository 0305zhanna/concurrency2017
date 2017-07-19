package lesson170718.Homework.produserconsumer;

import lesson170310.Utils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by User on 13.07.2017.
 */
public class SynchQueueExample {

    static final Random random = new Random();

    public static void main(String[] args) {

        ArrayBlockingQueue<String> window = new ArrayBlockingQueue<String>(4);

        Cook cook = new Cook(window);

        Waiter waiter = new Waiter(window);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(cook);
        service.execute(waiter);

        service.execute(() ->{
            while (true){
                Utils.pause(1000);
                System.out.println(window.size());
//                if(window.size()>2) {
//                    service.execute(new Waiter(window));
//                }
            }
        });
    }
}
