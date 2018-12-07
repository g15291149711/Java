class Person{
    // public void print(){
    //     System.out.println("[print方法]" + this);
    // }
    {
        System.out.println("1.Person类的构造块");
    }
    public Person(){
        System.out.println("2.Person类中的构造方法");
    }
    static {
        System.out.println("3.Person类中的静态块");
    }
}
public class Test{
    {
        System.out.println("4.主类中的构造块");
    }
    public Test(){
        System.out.println("5.主类中的构造方法");
    } 
    static{
        System.out.println("6.主类中的静态块");
    }
    public static void main(String[] args){
        //this表示当前对象
        // Person p1 = new Person();
        // System.out.println("main方法" + p1);
        // p1.print();
        //代码块
    //     {
    //         int x = 10;
    //         System.out.println("x = " + x);
    //     }
    //    int x = 100;
    //    System.out.println("x = " + x);
    new Test();
    new Person();
    new Person();
    }
}