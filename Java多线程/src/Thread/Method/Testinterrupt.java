package Thread.Method;
//线程停止
class Mythreadinterrupt implements Runnable{
    private boolean flag = true;

    @Override
    public void run() {
       /* int i = 1;
       while(flag){
           try {
               Thread.sleep(1000);
               System.out.println(Thread.currentThread().getName() + "执行， i = " + i++ );
           } catch (InterruptedException e) {
               e.printStackTrace();
           }*/
       int i = 1;
       while(flag){
           try {
               Thread.sleep(1000);
               boolean bool = Thread.currentThread().isInterrupted();
               if(bool){
                   System.out.println("非阻塞情况下执行该操作。。。线程状态" + bool);
                   break;
               }
               System.out.println("第" + i + "次执行，线程名为" + Thread.currentThread().getName());
               i++;
           } catch (InterruptedException e) {
               //
               System.out.println("退出了");
               boolean bool = Thread.currentThread().isInterrupted();
               System.out.println(bool);
               return;
           }
       }
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
public class Testinterrupt {
    public static void code1() throws InterruptedException {
        //设置标记法
        Mythreadinterrupt mythreadinterrupt = new Mythreadinterrupt();
        Thread thread = new Thread(mythreadinterrupt,"子线程A");
        thread.start();
        //设置停止时间
        Thread.sleep(5000);
        mythreadinterrupt.setFlag(false);
        System.out.println("代码结束");
    }
    public static void main(String[] args) throws InterruptedException {
        Mythreadinterrupt mythread = new Mythreadinterrupt();
        Thread thread = new Thread(mythread,"子线程A");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println("代码结束");
    }
}
