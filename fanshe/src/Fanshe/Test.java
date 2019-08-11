package Fanshe;

import java.util.Date;
interface IMessage{
}
class MyClass implements IMessage{}
/*public class Test {
    public static void main(String[] args) throws ClassNotFoundException{
        Date date = new Date();
        //取得Date类的Class对象
        Class<Date> cls = (Class<Date>) date.getClass();// 1.通过Object中的getclass（）方法
        System.out.println(cls);
        System.out.println(Date.class); //2. 类.class
        Class cls1 = Class.forName("java.util.Date");//3.通过Class提供的方法
        System.out.println(cls1);
        Class<?> cls2 =  Test.class;//取得package名称
        System.out.println(cls2.getPackage());
        System.out.println(cls2.getSuperclass());//取得父类名称
        Class <?>[] iClass = MyClass.class.getInterfaces();//取得父接口对象
        for(Class<?> class1 : iClass){
            System.out.println(class1.getName());
        }
    }
}*/
class Person2332{

}
public class Test{
    public static void main(String[] args) throws Exception{
        Class<Person2332> cls = Person2332.class;
        Person2332 date = cls.newInstance();//通过反射取得Date类对象
        System.out.println(date);
    }
}
