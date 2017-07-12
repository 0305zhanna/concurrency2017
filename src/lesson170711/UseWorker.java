package lesson170711;

/**
 * Created by User on 12.07.2017.
 */
public class UseWorker {

    public static void main(String[] args) {
        SimpleWorker worker = new SimpleWorker();

        worker.process(() ->{
            System.out.println("you did it!");
        });
        worker.process(() ->{
            System.out.println("you did it!");
        });
        worker.process(() ->{
            System.out.println("you did it!");
        });
    }

}
