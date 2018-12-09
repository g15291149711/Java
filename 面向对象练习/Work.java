//1
// class Test{
//     public int i;
//     public char a;
// }
// public class Work{
//     public static void main(String[] args){
//         Test t = new Test();
//         System.out.println(t.i);
//         System.out.println(t.a);
//     }
// }
//编写一个程序，展示无论你创建了某个特定类的多少个对象，
//这个类的某个特定的static成员变量只有一个属性。 
// class Dog{
//     public static String zhonglei = "犬类";
//     private String name;
//     private int age;
//     public Dog(String name,int age){
//         this.name = name;
//         this.age = age;
//     }
//     public void getDogs(){
//         System.out.println("叫" + name + "的狗今年" + age +"岁是" + zhonglei);
//     } 
// }
// public class Work{
//     public static void main(String[] args){
//        Dog d1 = new Dog("毛毛",8);
//        Dog d2 = new Dog("球球",6);
//        d1.getDogs();
//        d2.getDogs();
//     }
// }
////斐波那契数
class Fib{
    private int a;
    private int b;
    private int c;
    int n = 10;
    public Fib(int a,int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void fun(){
        if(n > 2){
            System.out.print(1 + " " + 1 + " ");
        }
        while(n > 2){
            n = n - 1;
            b = a;
            a = c;
            c = a + b;
            System.out.print(c + " ");
        }
    }
}
public class Work{
    public static void main(String[] args){
        Fib b = new Fib(1,0,1);
        b.fun();
    }
}
//4.
// class Hello{
//     private String a;
//     private int b;
//     public Hello(){
//         System.out.println("Hello Constructor");
//     }
//     public Hello(String a){
//         this();
//         System.out.println(a);
//     }
//     public Hello(String a,int b){
//         System.out.println("hehehe");
//     }
// }
// public class Work{
//     public static void main(String[] args){
//          Hello hello = new Hello("lalala");
//     }
// }