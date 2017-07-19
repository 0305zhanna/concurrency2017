package lesson170705.Homework.Deadlock;

/**
 * Created by User on 19.07.2017.
 */
public class UsePhilosopher {
    public static void main(String[] args) {
        System.out.println("start");

        Fork f1 = new Fork();
        Fork f2 = new Fork();
        Fork f3 = new Fork();
        Fork f4 = new Fork();
        Fork f5 = new Fork();

        new Thread(new Philosopher(f1,f2)).start();
        new Thread(new Philosopher(f2,f3)).start();
        new Thread(new Philosopher(f3,f4)).start();
        new Thread(new Philosopher(f4,f5)).start();
        new Thread(new Philosopher(f5,f1)).start();

    }
}
