package Testproduceandspeed;

class Mythread implements Runnable {
    private boolean flag;
    //对象锁
    private Object object;

    public Mythread(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    public void waitThread(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName() + "wait begin...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "wait end...");
        }
    }
    public void notifyThread(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName() + "notify begin————");
            object.notifyAll();//多个线程
            System.out.println(Thread.currentThread().getName() + "notify end————");
        }
    }
    @Override
    public void run() {
        if(flag){
            waitThread();
        }else{
            notifyThread();
        }
    }
}
public class Testwaitandnotify {
    public static void main(String[] args) {
        Object object = new Object();
        Mythread mythread = new Mythread(true,object);
        Mythread mythread1 = new Mythread(false,object);
        //多个线程
        for(int i = 0; i < 10; i++){
            Thread waitThread = new Thread(mythread,"lalala" + i);
            waitThread.start();
        }
        Thread thread1 = new Thread(mythread1,"hehehe");
        thread1.start();
    }
}
