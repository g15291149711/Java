package Testtongbuyusisuo;

import java.util.Map;

class MyThread20 implements Runnable{
    private int ticket = 10;

    @Override
    public void run() {
      /* for(int i = 0; i < 10; i++){
           //为程序上锁
            synchronized (this){
                if(this.ticket > 0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "还剩下" + this.ticket-- + "票");
                }
            }
        }*/
      for(int i = 0; i < 10; i++){
          sale();
      }
    }
    //表示此时只有一个线程能够进入此方法（同一个对象），隐式锁对象
    public synchronized void sale(){
        if(this.ticket > 0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还剩下" + ticket-- + "票");
        }
    }
}
public class Testsynchized {
    public static void main(String[] args) {
        MyThread20 myThread = new MyThread20();
        Thread thread = new Thread(myThread,"黄牛A");
        Thread thread1 = new Thread(myThread,"黄牛B");
        Thread thread2 = new Thread(myThread,"黄牛C");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
