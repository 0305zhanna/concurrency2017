package lesson170705.Homework;

import lesson170310.Utils;

/**
 * Created by User on 07.07.2017.
 */
public class Philosopher {
    private int canEat = 0;
    void takeLeft(Fork f){
        synchronized (f){
            System.out.println(Thread.currentThread().getName()+" Took Left fork");
            canEat++;
            //Utils.pause(1000);
        }
    }
    void takeRight(Fork f){
        synchronized (f){
            System.out.println(Thread.currentThread().getName()+" Took Right fork");

            //            Utils.pause(1000);
        }
    }
}
