package Testtongbuyusisuo;
//用代码 证明锁的可重入性和互斥
class MYthread implements Runnable{
    public synchronized void testA(){
         while(true){
             testB();
         }
    }
    public synchronized void testB(){

    }

    @Override
    public void run() {
        synchronized (this){

        }
    }
}
public class Testmonitorenter {
    public static void main(String[] args) {
         MYthread mYthread = new MYthread();
         new Thread(mYthread).start();
    }
}
