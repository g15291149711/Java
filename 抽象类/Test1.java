//内部抽象类允许使用static
// abstract class A{
//    public abstract void printA();
//         static abstract class B{
//             public abstract void printB();   
//         }
// }
// class X extends A.B{
//     public void printB(){}
// }
// public class Test1{
//     public static void main(String[] args){
//           new X();
//     }
// }
//模板设计方法
//普通方法
// class Coffee{
//     void preparRecipe(){
//         boilWater();
//         brewCoffeeGrings();
//         pourInCup();
//         addSugarAndMilk();
//     }
//     public void boilWater(){
//         System.out.println("将水煮沸");
//     }
//     public void brewCoffeeGrings(){
//         System.out.println("用沸水冲泡咖啡");
//     }
//     public void pourInCup(){
//         System.out.println("将咖啡倒进杯子");
//     }
//     public void addSugarAndMilk(){
//         System.out.println("加糖和牛奶");
//     }
// }
// class Tea{
//     void preparRecipe(){
//         boilWater();
//         steepTeaBag();
//         pourInCup();
//         addLemon();
//     }
//     public void boilWater(){
//         System.out.println("将水煮沸");
//     }
//     public void steepTeaBag(){
//         System.out.println("冲泡茶");
//     }
//     public void pourInCup(){
//         System.out.println("将茶倒进杯子");
//     }
//     public void addLemon(){
//         System.out.println("加柠檬");
//     }
// }
// public class Test1{
//     public static void main(String[] args){
//         new Coffee().preparRecipe();
//         new Tea().preparRecipe();
//     }
// }
//抽象模板方法
abstract class CaffeeineBeverage{
    final void prepareRecipe(){//定义步骤用final
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("将水煮沸");
    }
    void pourInCup(){
        System.out.println("将饮料倒入杯子");
    }
}
class Tea extends CaffeeineBeverage{
    void brew(){
        System.out.println("冲泡茶");
    }
    void addCondiments(){
        System.out.println("加柠檬");
    }
}
class Coffee extends CaffeeineBeverage{
    void brew(){
        System.out.println("冲泡咖啡");
    }
    void addCondiments(){
        System.out.println("加糖和牛奶");
    }
}
public class Test1{
    public static void main(String[] args){
        CaffeeineBeverage c = new Tea();
        c.prepareRecipe();
        CaffeeineBeverage b = new Coffee();
        b.prepareRecipe();
    }
}