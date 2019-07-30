package Stream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

class Order{
    private String title;
    private double price;

    public Order(String title, double price, int amount) {
        this.title = title;
        this.price = price;
        this.amount = amount;
    }

    private int amount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
public class TestReduce {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order("Java数据结构",8899.99,10));
        list.add(new Order("苹果电脑",12999.99,5));
        list.add((new Order("MACBookpro",18999.99,5)));
        list.add(new Order("Java从入门到放弃",9.99,2200));
        list.add(new Order("油笔",1,2000));
        Double Allprice = list.stream().map(order -> order.getAmount() * order.getPrice()).
                reduce((sum,x) -> sum + x).get();
        System.out.println("总金额"+ Allprice);
        DoubleSummaryStatistics dss =
                list.stream().mapToDouble((order) ->order.getPrice()*order.getAmount())
                        .summaryStatistics();
        System.out.println("总量" +dss.getCount());
        System.out.println("平均值" + dss.getAverage());
    }
}
