package Fanshe;
//反射调用构造方法
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person{
    private String name;
    private int age;
    public Person(){

    }
    private Person(String name){

    }
    protected Person(String name,int age){
          this.name = name;
          this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person>cls = Person.class;//先取得类的class对象
        /*Constructor [] constructors = cls.getDeclaredConstructors();//取得类中所有构造方法与权限无关
        for(Constructor constructor : constructors){
            System.out.println(constructor.getName());
        }*/
        Constructor constructor = cls.getDeclaredConstructor(String.class,int.class);//取得类中指定构造方法
        System.out.println(constructor);
        //动态破坏封装
        constructor.setAccessible(true);
        //调用构造方法实例化对象,通过反射调用newinstance方法调用对象
        Person per = (Person) constructor.newInstance("sad",15);
        System.out.println(per);
    }
}
