//向上转型操作参数统一化
// class Person{
//     public void print(){
//         System.out.println("1.我是人类");
//     }
// }
// class Student extends Person{
//     public void print(){
//         System.out.println("2.我是学生");
//     }
// }
// class Worker extends Person{
//     public void print(){
//         System.out.println("3.我是工人");
//     }
// }
// public class Test{
//     public static void main(String[] args){
//         Person per = new Person();
//         per.print();
//         whoyouare(new Student() );
//         whoyouare(new Worker() );
//     }
//     public static void whoyouare(Person per){
//         per.print();
//     }
// }
//内部类
//内部类可以直接访问外部类的元素
//外部类可以通过内部类间接访问内部类元素
// class Outter{
//     // private String msg = "Hello World";
//     private String outName;
//     private int outAge;
//     class Inner{
//         // public void print(){
//         //     System.out.println(msg);
//         // }
//         private int InnerAge;
//         public Inner(){
//             Outter.this.outName = "I am Outter class";
//             Outter.this.outAge = 20;
//         }
//         public void display(){
//             System.out.println(outName);
//             System.out.println(outAge);
//         }
//     }
//     // public void fun(){
//     //     Inner in = new Inner();
//     //     in.print();
//     // }
// }
// public class Test{
//         public static void main(String[] args){
//         //   Outer out = new Outer();
//         //   out.fun();
//         Outter.Inner inner = new Outter().new Inner();
//         inner.display();
//         }
// }
// class Outter{
//     public void display(){
//         Inner inner = new Inner();
//         inner.display();
//     }
//     class Inner{
//         public void display(){
//             System.out.println("我是啥");
//         }
//     }
// }
// public class Test{
//     public static void main(String[] args){
//          Outter out = new Outter();
//          out.display();
//     }
// }
//成员内部类
//Outter.Inner.inner = new Outter().new Inner();
//Inner inner = new Inner();
//静态内部类
// class Outter{
//     private static String msg = "你好";
//     static class Inner{
//         public void print(){
//             System.out.println(msg);
//         }
//     }
//     public void fun(){
//         Inner inner = new Inner();
//         inner.print();
//     }
// }
// public class Test{
//     public static void main(String[] args){
//          Outter.Inner inner = new Outter.Inner();
//          inner.print();
//     }
// }
//方法内部类
class Outter{
    private int num;
    public void display(int test){
        class Inner{
            private void fun(){
                num++;
                System.out.println(num);
                System.out.println(test);
            }
        }
        new Inner().fun();
    }
}
public class Test{
    public static void main(String[] args){
         Outter out = new Outter();
         out.display(20);
    }
}
