import lesson170310.Utils;

/**
 * Created by User on 05.07.2017.
 */
public class SyncMulti {

    synchronized void change(){
        for(int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + " "+i);
            Utils.pause(1000);
            }
}

    public static void main(String[] args){
        SyncMulti sync = new SyncMulti();
        new Thread(() ->{
            sync.change();
        }).start();
        new Thread(() ->{
            sync.change();
        }).start();
        new Thread(() ->{
            sync.change();
        }).start();

        sync.change();
    }
}
