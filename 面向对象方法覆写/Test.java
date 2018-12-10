//方法的覆写
//属性的覆写
// class Person{
//     public String i = "Person";
//     public void print(){
//         System.out.println("1.Person中的print方法");
//     }
// }
// class Student extends Person{
//     public String i = "Student";
//     public void print(){
//         System.out.println("2.Student类的print方法");
//     }
// }
// public class Test{
//     public static void main(String[] args){
//             new Student().print();
//             System.out.println(new Student().i);
//     }
// }
//super关键字
// class Person{
//     public int a;
//     public String j = "儿子";
//     public Person(){
//     }
//     public Person(int a){
//         System.out.println("2.父类中的有参构造");
//     }
//     public void print(){
//         System.out.println("1.I am father");
//     }
// }
// class Student extends Person{
//     public String j = "erzi";
//     private String school;
//     public Student(){
//         super(2);
//         System.out.println("1.子类中的构造方法");
//     }
//     public Student(String school){
//         this();
//         this.school = school;
//     }
//     public void print(){
//         super.print();
//         System.out.println("2.I am student");
//         System.out.println(super.j);
//     }
// }
//多态（方法覆写）
class Person{
    public void print(){
        //System.out.println("1.我是爸爸");
        System.out.println("Person类中的print方法");
    }
}
class Student extends Person{
    public void print(){
        //System.out.println("2.我是儿子");
        System.out.println("Student类中的printf方法");
    }
}
class Worker extends Person{
    public void print(){
        System.out.println("Worker类中的print方法");
    }
}
public class Test{
    public static void main(String[] args){
        // Student stu = new Student();
        // stu.print();
        //向上转型
        // Person per = new Student();
        // per.print();
        //向下转型，需要强转
        // Student stu = (Student) per;
        // stu.print();
          fun(new Person());
          fun(new Student());
          fun(new Worker());
    }
    public static void fun(Person per){
        per.print();
    }
}