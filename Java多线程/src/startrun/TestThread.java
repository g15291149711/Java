package startrun;
class Mythread extends Thread {
    private String title;

    public Mythread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(this.title +",i =" + i);
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
      Mythread mythread = new Mythread("子线程A");
      Mythread mythread1 = new Mythread("子线程B");
      mythread.start();
      mythread1.start();
    }
}
