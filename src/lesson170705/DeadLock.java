/**
 * Created by User on 05.07.2017.
 */
public class DeadLock {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread() + "got" +a);
                synchronized (b){
                    System.out.println("Got it");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread() + "got" +b);
                synchronized (a){
                    System.out.println("Got it");
                }
            }
        }).start();
    }
}
