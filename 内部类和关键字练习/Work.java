// class Father{
//     private String name = "zhangjun";
//     public String getName(){
//         return name;
//     }
//     class Child{
//         public void introFather(){
//             System.out.println(name); 
//         }
//     }
// }
// public class Work{
//     public static void main(String[] args){
//         Father.Child child = new Father().new Child();
//         child.introFather();
//     }
// }
//2
// class A{
//     int y = 6;
//     class Inner{
//        static int y = 3;
//        void show(){
//            System.out.println(y);
//        }
//     }
// }
// public class Work{
//     public static void main(String args){
//        A.Inner in = new A().new Inner();
//     }
// }
//成员内部类中不能存在任何static变量或方法
//3
// class A{
//     public A(){
//         System.out.println("A");
//     }
// }
// class B extends A{
//     public B(){
//         System.out.println("B");
//     }
// }
// public class Work{
//     public static void main(String[] args){
//       B b = new B();
//     }
// }
//A , B
//4
// public class Work{
//     public static void main(String[] args){
//             for (int i=100; i < 1000; i++)
//             {
//                 int a = i % 10; 
//                 int b = (i / 10) % 10;  
//                 int c = i / 100;
//                 if (i == (Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3))){
//                     System.out.println(i);
//                 }
//             }
//     }
// }
//java中次方用Math.pow(a,b)表示a的b次方
//5
abstract class Role{
    private String name;
    private int age;
    private String sex;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
    public Role(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Role(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public abstract void play();
}
class Employee extends Role{
    private double salary;
    private static String ID;
    public  Employee(String name,int age,double salary){
          super(name,age);
          this.salary = salary;
    }
    public Employee(String name,int age,String sex,double salary){
        super(name,age,sex);
        this.salary = salary;
    }
   public void play(){
       System.out.println(this.getName()+"在"+this.getAge()+"岁时进了峡谷之巅");
   }
   public final void sing(){
       System.out.println(this.getName()+"寂寞的唱歌");
   }
}
class Manager extends Employee{
      public static final String vehicle = "haishiwolihai";
      public Manager(String name,int age,double salary){
          super(name,age,salary);
      }
}
public class Work{
    public static void main(String[] args){
        Role role = new Employee("我",18,200.0);
        role.play();
        Manager ma = new Manager("铭哥",25,3000);
        ma.sing();
        ma.play();
        System.out.println(ma.vehicle);
    }
}