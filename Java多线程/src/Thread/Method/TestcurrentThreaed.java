package Thread.Method;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

// CountDownLatch工具类的应用
class CoutDownLanth implements Runnable{
    private CountDownLatch countDownLatch;

    public CoutDownLanth(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "运动员跑步");
        countDownLatch.countDown();
    }
}
public class TestcurrentThreaed {
    //主方法是一个线程
    public static void main(String[] args) throws InterruptedException {
            CountDownLatch countDownLatch = new CountDownLatch(3);
          for(int i = 0; i < 3; i++){
              new Thread(new CoutDownLanth(countDownLatch),"运动员" + (i + 1)).start();
          }
          countDownLatch.await();
        System.out.println("运动员都跑完了");
    }
}
