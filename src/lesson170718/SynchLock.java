package lesson170718;

/**
 * Created by User on 19.07.2017.
 */
public class SynchLock {
    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        synchronized (o1){
            synchronized (o2){
            //need to free o1
            }
        }

    }
}
