package Thread.Method;
//线程优先级
class A implements Runnable{

    @Override
    public void run() {
        System.out.println("A的优先级为：" + Thread.currentThread().getPriority());
        Thread thread = new Thread(new Mythread0());
        thread.start();
    }
}
class Mythread0 implements Runnable{

    @Override
    public void run() {
            System.out.println("Mythed0的优先级为：" + Thread.currentThread().getPriority());
    }
}
public class TestPriority {
    public static void main(String[] args) {
   /*    Mythread0 mythread0 = new Mythread0();
       Thread thread = new Thread(mythread0,"线程A");
       Thread thread1 = new Thread(mythread0,"线程B");
       Thread thread2 = new Thread(mythread0,"线程C");
       //设置优先级
       thread.setPriority(Thread.MAX_PRIORITY);
       thread1.setPriority(Thread.MIN_PRIORITY);
       thread2.setPriority(Thread.NORM_PRIORITY);
       thread.start();
       thread1.start();
       thread2.start();
        //主线程的优先级
        System.out.println(Thread.currentThread().getPriority());*/
        Thread thread = new Thread(new A());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        //线程是有继承关系的，比如当A线程中启动B线程，那么B和A的优先级将是一样的
        //  10
    }
}
