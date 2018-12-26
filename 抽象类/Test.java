//抽象类
// abstract class Person{
//     private String name;
//     public String getName(){
//         return this.name;
//     }
//     public void setName(String name){
//         this.name = name;
//     }
//     public abstract void getPersonInfo();//抽象方法
// }
// class Student extends Person{
//     public void getPersonInfo(){
//         System.out.println("我是学生");
//     }
// }
// public class Test{
//     public static void main(String[] args){
//         Person per = new Student();//实例化子类，向上转型
//         per.getPersonInfo();
//     }
// }
//抽象类相关规定重要****
//在抽象类中定义构造方法
// abstract class Person{
//     private String name;
//     public Person(){
//         System.out.println("******");
//     }
//     public String getName(){
//         return this.name;
//     }
//     public void setName(String name){
//         this.name = name;
//     }
//     public abstract void getPersonInfo();
// }
// class Student extends Person{
//     public Student(){
//         System.out.println("#####");
//     }
//     public void getPersonInfo(){
//         //空实现
//     }
// }
// public class Test{
//     public static void main(String[] args){
//         new Student();
//     }
// }
//考题
abstract class A{
    public A(){//3先调用父类构造
        this.print();
    }
    public abstract void print();//4调用被子类覆写的方法
}
class B extends A{
    private int num = 100;
    public B(int num){//2调用子类实例化对象
        super();//3隐藏一行语句，实际要先调用父类构造
        this.num = num;//7为类中属性初始化
    }
    public void print(){//5此时子类对象的属性还没有被初始化
        System.out.println(this.num);//6对应其数据类型的默认值
    }
}
public class Test{
    public static void main(String[] args){
         new B(30);//1实例化子类对象
    }
}