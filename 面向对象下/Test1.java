class Person{
    private String name;
    private int age;
    public void setName(String name){
        this.name = name;
    } 
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
         return age;
    }
}
class Student extends Person{
    private String school;
    public void setSchool(String school){
         this.school = school;
    }
    public String getSchool(){
        return school;
    }
}
public class Test1{
    public static void main(String[] args){
       Student stu = new Student();
       stu.setName("鹏哥");
       stu.setAge(18);
       stu.setSchool("石油大学");
       System.out.println(stu.getName()+stu.getAge() + "是"+ stu.getSchool());
    }
}