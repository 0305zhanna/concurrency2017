/**
 * Created by User on 05.07.2017.
 */
public class EvilCounterUsage {
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println("starting evil thread");
        new Thread(() -> {
            synchronized (c){
                while(true){}
            }
        }).start();
        System.out.println("starting good thread");
        new Thread(()->{
            while (true){
                c.inc();

            }
        }).start();
        new Thread(()->{
            while (true){
                System.out.println(c.getCount());
            }
        }).start();

    }
}
