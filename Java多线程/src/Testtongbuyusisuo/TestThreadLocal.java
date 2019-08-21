package Testtongbuyusisuo;

public class TestThreadLocal {
    private static String commer;
    private static ThreadLocal<String> threadLocal = /*new ThreadLocal()*/ThreadLocal.
            withInitial(()-> {
                return "Hello word";//定义初始化值
            });
    public static void main(String[] args) {
       /* commer = "main";
        threadLocal.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("   " + threadLocal.get());
                commer = "thread";
                threadLocal.set("thread");
                //弱引用 gc
                System.out.println("   " +threadLocal.get());
                threadLocal.remove();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commer);
        System.out.println(threadLocal.get());
        //threadLocal 在一个线程中设置值，不影响其在其他线程中的值,他是独立的*/
       StringBuffer sb = new StringBuffer();
       sb.append("sda");
       sb.append("sd");
       sb.append("s");
        System.out.println(sb);
    }
}
