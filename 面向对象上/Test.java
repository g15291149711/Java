class person{
    //先定义属性，然后构造方法，最后普通方法
    private String name;
    private int age;
    public person(String n,int i){
        name = n;
        setAge(i);
    }
    public person(){
        System.out.println("*******");
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int i){
        if(i > 0 && i < 200){
            age = i;
        }else{
            age = 0;
        }
    }
    public int getAge(){
        return age;
    }
    public void fun(){
        System.out.println(name + "在" + age + "岁打豆豆");
    }
    public void eat(){
        System.out.println(name + "吃饭");
    }
}
public class Test{
    public static void main(String[] args){
    person per = new person("马云",200);//构造方法后可以使用
    person per1 = new person();//构造方法按照个数大小排列
    // per.setName("张三");
    // per.setAge(-200);
    // person per1 = new person();  
    // per1 = per;
    // per1.age = 20;//有private封装不能访问
    new person("张三",20).fun();//匿名对象不会有任何的栈空间指向，用过一次就成为垃圾空间
    per.fun();
    per.eat();
    }
}