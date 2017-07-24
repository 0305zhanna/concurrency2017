package lesson170720;

import java.util.concurrent.Semaphore;

/**
 * Created by User on 24.07.2017.
 */
public class SemCounter {

    private int count = 0;
    Semaphore sem = new Semaphore(1);

    public int get(){
        sem.acquireUninterruptibly();
        try {

            return count;
        }finally {
            sem.release();
        }
    }

    public void inc(){
        sem.acquireUninterruptibly();
        try {
            count++;

        }finally {
            sem.release();
        }
    }

}
