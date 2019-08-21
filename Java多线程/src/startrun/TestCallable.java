package startrun;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread5 implements Callable<String>{
    private int ticket = 10;
    public String call() throws Exception{
       for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "还剩下" + ticket-- + "票");
            Thread.sleep(1000);
        }
        return "票卖完了，明天来";
    }
}
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread5());
        Thread thread = new Thread(futureTask);
        System.out.println(thread.getName());
        thread.setName("线程A");
        thread.start();
        System.out.println(futureTask.get());
    }
}
