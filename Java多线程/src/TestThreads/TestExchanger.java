package TestThreads;


import java.util.concurrent.Exchanger;


public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        Thread girl = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str = exchanger.exchange("我喜欢你很久了");
                    System.out.println("女生说：" + str);
                 } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        girl.start();
        Thread boy = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("啦啦啦");
                try {
                    Thread.sleep(2000);
                    String str = exchanger.exchange("我喜欢你");
                    System.out.println("男生说:" + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        boy.start();
    }
}
