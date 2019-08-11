package Fanshe;

import java.lang.reflect.Field;

//反射调用类中属性
class Persons{
    private int age;
}
public class Test3 {
    public static void main(String[] args)throws Exception {
          /* Class<Student> cls = Student.class;
        {
            Field[] fields = cls.getFields();//在父类和本类中找所有属性包括static属性
            for(Field field : fields){
                System.out.println(field);
            }
        }
        System.out.println("-------------");
        {
            Field[] fields = cls.getDeclaredFields();//只在本类中找所有属性包括private属性
            for(Field field : fields){
                System.out.println(field);
            }*/
        Class<Persons> cls = Persons.class;
        Object object = cls.newInstance();
        Field field  = cls.getDeclaredField("age");
        field.setAccessible(true);
        field.set(object,20);
        System.out.println(field.get(object));
        System.out.println(field.getType());
    }
}
