package startrun;
class MyThread implements Runnable{
    private int k = 20;
    @Override
    public void run() {
       while(k > 0){
           System.out.println(Thread.currentThread().getName() + "当前票数为" + k--);
       }
    }
}
public class TestRunnable {
    public static void main(String[] args) {
         Runnable runnable = ()-> System.out.println("saf");
         new Thread(runnable).start();
         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println("lll");
             }
         }).start();
         MyThread myThread = new MyThread();
        System.out.println(Thread.currentThread().getName());
         Thread thread = new Thread(myThread,"黄牛A");
         Thread thread1 = new Thread(myThread,"黄牛B");
         thread.start();
         thread1.start();
    }
}
