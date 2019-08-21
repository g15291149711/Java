package TestThreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

//  CyclicBarrier的使用
class NCycicBarrier implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public NCycicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在写数据");
        try {
            TimeUnit.SECONDS.sleep(2);
            cyclicBarrier.await();
            System.out.println("所有线程都执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
public class TestCyclicBarrier {
    public static void main(String[] args) {
         CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
             @Override
             public void run() {
                 System.out.println("随机挑选一个线程执行此任务" + "" +
                         "  当前线程为：" + Thread.currentThread().getName());
             }
         });
        for (int i = 0; i < 3; i++) {
            new Thread(new NCycicBarrier(cyclicBarrier),"写者" + (i + 1)).start();
        }
    }
}
