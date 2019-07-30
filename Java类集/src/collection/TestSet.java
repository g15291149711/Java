package collection;

import java.util.*;

//Comparble接口内部排序
/*
class  Student implements Comparable<Student>{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    //自定义Person类如何比较大小
    public int compareTo(Student o) {
       if(this.age > o.age ){
           return 1;
       }else if(this.age < o.age){
           return -1;
       }else{
           return this.name.compareTo(o.name);
       }
    }
}
*/



class  Student{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
/*
/**
 * Student类的比较器
 * 升序比较从大到小
 */
class AscAgeComparator  implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getAge() - o2.getAge();
    }
}
public class TestSet {
    public static void main(String[] args) {
      Set<Student> set = new TreeSet<>(new AscAgeComparator());
       set.add(new Student("wnagsd",520));
       set.add(new Student("lalala",20));
       set.add(new Student("lalala",20));
       set.add(new Student("add",480));
       System.out.println(set);
    }
}
