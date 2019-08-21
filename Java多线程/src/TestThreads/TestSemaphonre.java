package TestThreads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class NSemaphonre implements Runnable{
    private int num; //几个工人占用机器
    private Semaphore semaphore;

    public NSemaphonre(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(2);
            System.out.println("工人" + this.num + "占用一台设备在生产");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("工人" + this.num + "释放一台设备");
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestSemaphonre {
    public static void main(String[] args) {
        int Worker = 8;
        Semaphore semaphore = new Semaphore(6);
        for(int i = 0; i < Worker; i++){
            new Thread(new NSemaphonre(i + 1,semaphore)).start();
        }
    }
}
