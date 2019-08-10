package fanixng;
class Person<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
public class Message{
    public static void main(String[] args){
        Person<String> person = new Person<>();
        person.setMessage("nihao");
        fun(person);
    }
    public static void fun(Person<? super String> temp){//  <String>参数类型被确定，方法只能接受一种类型
        temp.setMessage("lalalaa");
        System.out.println(temp.getMessage());//  ? 通配符只用在方法级别 可以接受任意类型，但是不能修改
    }
}
//  ? extends 类 : 设置泛型上限         ？super 类： 设置泛型下限
// 上限可以用在声明，不能修改，而下限只能用在方法参数，可以修改内容
//泛型接口
//在类型被类型擦除的时候，之前泛型类中的类型参数部分如果没有指定上限<T> 则会转换为
// 普通的Object类型，如果指定上限如<T extends String> 则类型会转换为 String