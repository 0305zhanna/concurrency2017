/**
 * Created by User on 05.07.2017.
 */
public class Sync {

//     static  void change(){
//        synchronized (Sync.class){
//            for(int i = 0; i<10; i++){
//                System.out.println(Thread.currentThread().getName() + " "+i);
//            }
//        }
//    }

    synchronized void change(){
//    synchronized (this){
        for(int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + " "+i);
            }
//    }
}

    public static void main(String[] args){
        Sync sync = new Sync();
        new Thread(() ->{
            sync.change();
        }).start();

        sync.change();
    }
}
