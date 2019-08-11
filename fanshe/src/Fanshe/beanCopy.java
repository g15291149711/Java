package Fanshe;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
class Teacher{
    private String name;
    private String kill;
    private Boolean gender;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKill() {
        return kill;
    }

    public void setKill(String kill) {
        this.kill = kill;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", kill='" + kill + '\'' +
                ", gender=" + gender +
                '}';
    }
}
class User{
    private String name;
    private String password;
    private Boolean gender;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
public class beanCopy {
    public static void main(String[] args) {
          Teacher teacher = new Teacher();
          teacher.setName("Peter");
          teacher.setGender(true);
          teacher.setKill("杀猪");
        User user = new User();
          beanCopy.copy(teacher,user);
        System.out.println(teacher);
        System.out.println(user);
    }
    public static void copy(Object source,Object target){
        if(source == null || target == null ){
            throw new IllegalArgumentException("俩个对象不能为null");
        }
        //1.获取对象的class对象
        Class sourceClass  = source.getClass();
        Class targetClass  = target.getClass();
        //2.获取Class对象中的属性
        Field[] sourceFiled = sourceClass.getDeclaredFields();
        Field[] targetFiled = targetClass.getDeclaredFields();
        //3.sourceFileld 找 targetFiled      属性名称
        for(Field s : sourceFiled){
            for(Field t : targetFiled){
                if(s.getName().equals(t.getName())){
                    try {
                        t.setAccessible(true);
                        s.setAccessible(true);
                        Object o = s.get(source);
                        t.set(target,o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
