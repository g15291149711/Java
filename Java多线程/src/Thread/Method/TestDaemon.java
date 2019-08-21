package Thread.Method;
//守护线程
class Mythread10 implements Runnable{

    @Override
    public void run() {
        int i = 1;
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()
                        + "是否是守护线程   " + Thread.currentThread().isDaemon());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "退出");
                return;
            }
        }
    }
}
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
      /*  System.out.println(Thread.currentThread().getName() + "是否是守护线程  "
                + Thread.currentThread().isDaemon());*/
      Mythread10 mythread0 = new Mythread10();
      Thread thread = new Thread(mythread0,"子线程A");
      Thread thread1 = new Thread(mythread0,"子线程B");
      //必须在线程启动之前执行
      thread.setDaemon(true);
      thread.start();
      thread1.start();
      Thread.sleep(3000);
      //中断非守护线程
      thread1.interrupt();
    }
}
