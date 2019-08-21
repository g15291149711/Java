package Thread.Method;
class Mythread7 extends Thread {
    private String title;

    public Mythread7(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            System.out.println(this.title +",i =" + i);
        }
    }
}
public class Testsleep {
    public static void main(String[] args) throws InterruptedException {


    }
}
