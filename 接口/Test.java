// interface IMessage{
//     public static final String MSG_NIUBI = "lalala";//常量
//     public abstract void print();//抽象方法
// }
// interface INews{
//     public abstract String getNews();
// }
// class MessageImpl implements IMessage,INews{
//     public void print(){
//         System.out.println(IMessage.MSG_NIUBI);
//     }
//     public String getNews(){
//         return IMessage.MSG_NIUBI;//访问常量建议加上类名称
//     }
// }
// public class Test{
//     public static void main(String[] args){
//          IMessage m = new MessageImpl();//子类向上转型
//          m.print();//调用被子类覆写过的方法
//          INews n = (INews)m;//父接口的相互转换
//          n.getNews();
//     }
// }
//在接口中属性与方法不需要加任何修饰符
// interface IMessage{
//      void print();
// }
// abstract class News{
//     public abstract void getNews();
// }
// class MessageImpl extends News implements IMessage{
//     public void print(){//先使用extends继承抽象类再用implements实现接口
//         System.out.println("你好");
//     }
//     public void getNews(){
//         System.out.println("bate");
//     }
// }
// public class Test{
//     public static void main(String[] args){
//         IMessage m = new MessageImpl();
//         m.print();
//         News n = (News)m;//父类与父类接口有相同子类，可以相互转换
//         n.getNews();
//     }
// }
//抽象类继承接口
// interface IMessage{
//     public void print();
// }
// abstract class News implements IMessage{
//     //News为抽象类，可以不实现IMessage中的抽象方法
//     public abstract void getNews();
// }
// class MessageImpl extends News{
//     public void print(){
//         System.out.println("我来了");
//     }
//     public void getNews(){
//         System.out.println("好好学习");
//     }
// }
// public class Test{
//     public static void main(String[] args){
//         IMessage m = new MessageImpl();
//         m.print();//MessageImpl是抽象类与子类共同的接口
//         News n = (News) m;
//         n.getNews();
//     }
// }
//如果这么写class MessageImpl extends News implements IMessage
//只是为了强调Message是IMessage的实现类
//一个接口可以使用extends继承多个父接口
//接口的应用
//定义操作标准如USB
//表示能力或行为如购买商品
//在分布式开发之中暴露远程服务方法
interface USB{//定义一个USB标准
    public void setup();//安装USB驱动
    public void work();//进行工作
}
class Computer{//定义电脑类
    public void plugin(USB usb){//只能插USB设备
        usb.setup();//安装
        usb.work();//工作
    }
}
class UDisk implements USB{//定义USB类定义一个usb设备
    public void setup(){
        System.out.println("安装U盘驱动");
    }
    public void work(){
        System.out.println("U盘开始工作");
    }
}
class PrintDisk implements USB{//定义一个usb设备
    public void setup(){
        System.out.println("安装打印机驱动");
    }
    public void work(){
        System.out.println("打印机开始工作");
    }
}
public class Test{
    public static void main(String[] args){
        Computer c = new Computer();
        c.plugin(new UDisk());//USB usb = new UDisk();向上转型
        c.plugin(new PrintDisk());//USB usb = new PrintDisk();
    }
}
