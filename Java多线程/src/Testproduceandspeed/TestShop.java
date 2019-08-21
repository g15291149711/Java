package Testproduceandspeed;

import java.util.ArrayList;
import java.util.List;

//单人单消费
class Goods{
    //商品名称
    private String goodsName;
    //商品数量
    private int count;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
    //生产商品方法
    public synchronized void setGoods(String goodsName){
        //当前还有商品，需要消费者消费
       while(count > 0){
            try {
                System.out.println("还有商品，歇会");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        this.count++;
        System.out.println(Thread.currentThread().getName() + "生产" + toString());
        //生产完商品后通知消费者线程可以继续消费了
        notifyAll();
    }
    //消费商品方法
    public synchronized void getGoods(){
        //当前还没有商品，消费者需要等待。
        while(this.count == 0){
            System.out.println("商品卖完了，客关稍等");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName() + "消费" + toString());
        //消费完告知生产者可以继续生产了
        notifyAll();
    }
}
//生产者
class Producer implements Runnable{
private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        while(true){
            this.goods.setGoods("宝马x6");
        }
    }
}
//消费者
class Consumer implements Runnable{
private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
       while(true){
           this.goods.getGoods();
       }
    }
}
public class TestShop {
    public static void main(String[] args) {
        //一个生产者一个消费者
         /* Goods goods = new Goods();
          Producer producer = new Producer(goods);
          Consumer consumer = new Consumer(goods);
          Thread thread = new Thread(producer,"生产者");
          Thread thread1 = new Thread(consumer,"消费者");
          thread1.start();
           thread.start();*/
         //多个生产者多个消费者
        Goods goods = new Goods();
        List<Thread> list = new ArrayList<>();
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        //五个生产者
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(producer,"生产者" + 1);
            list.add(thread);
        }
        //五个消费者
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(consumer,"消费者" + i);
            list.add(thread);
        }
        for(Thread thread : list){
            thread.start();
        }
    }
}
