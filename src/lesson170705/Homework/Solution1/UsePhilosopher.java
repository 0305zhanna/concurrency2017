package lesson170705.Homework.Solution1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 19.07.2017.
 */
public class UsePhilosopher {
    public static void main(String[] args) {
        System.out.println("start");

        List<Fork> forks = new LinkedList<>();
        for(int i = 1; i<=5;i++){
            forks.add(new Fork(i));
        }

        new Thread(new Philosopher(forks.get(0),forks.get(1))).start();
        new Thread(new Philosopher(forks.get(1),forks.get(2))).start();
        new Thread(new Philosopher(forks.get(2),forks.get(3))).start();
        new Thread(new Philosopher(forks.get(3),forks.get(4))).start();
        new Thread(new Philosopher(forks.get(4),forks.get(0))).start();
    }
}
