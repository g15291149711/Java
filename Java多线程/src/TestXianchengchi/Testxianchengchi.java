package TestXianchengchi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Testxianchengchi {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10, 1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(20),
                //设置
                new ThreadFactory() {
            //原子变量Integer  AtomiticInteger
            private final AtomicInteger id = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("Thread - Handler - DataAnalysis - " +  id.getAndIncrement());
                        //1.设置名字 2.设置优先级  3.设置是否守护
                        return thread;
                    }
                },
        new ThreadPoolExecutor.DiscardOldestPolicy());
        // pool - index1 - thread - index2
       /* while(true){
            *//* Thread.sleep(500);*//*
               threadPoolExecutor.execute(new Runnable() {
                   @Override
                   public void run() {
                       System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                   }
               });*/
        for(int i = 0; i < 10; i++){
            //无返回值
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                }
            });
        }
        List<Future<String>> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
           Future<String> future =  threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Call " + Thread.currentThread().getName() + " " +
                            LocalDateTime.now().toString();
                }
            });
           //执行完就返回，在加新的任务
           /* try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
           //先收集
           list.add(future);
        }
        //异步处理，最后等结果
        for(Future future : list){
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
