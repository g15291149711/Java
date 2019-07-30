package collection;

import java.util.*;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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
}
public class TestList {
    public static void code1() {
        //list的简单实用  三个子类Vector，LinkedList使用上没有区别
        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.set(0,"p");
        linkedList.set(1,"d");
        System.out.println(linkedList.get(1));
        System.out.println(linkedList);
    }
    public static void code2(){
      List<Person> list = new ArrayList<>();
      list.add(new Person("张三",15));
        System.out.println(list);
        list.add(new Person("lisi",20));
        System.out.println(list);
    }
    public static void main(String[] args) {
        code1();
        code2();
    }

}
