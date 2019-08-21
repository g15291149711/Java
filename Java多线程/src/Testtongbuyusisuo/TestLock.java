package Testtongbuyusisuo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyLock implements Runnable{
    private int ticket = 1000;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
       for(int i = 0; i < 1000; i++){
           try {
               lock.lock();
               if(this.ticket > 0){
                   try {
                       Thread.sleep(20);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() +
                           "还剩下" + this.ticket-- + "票");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }finally {
               lock.unlock();
           }
           }
       }
}
public class TestLock {
    public static void main(String[] args) {
        MyLock mYthread = new MyLock();
        Thread thread1 = new Thread(mYthread,"A");
        Thread thread2 = new Thread(mYthread,"B");
        Thread thread3 = new Thread(mYthread,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
