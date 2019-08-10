package fanixng;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

//枚举实际上就是多例
//多例： 构造方法私有化，类内部需要提供若干个实例化对象，后面通过static 方法返回
interface Incolor{
    String getcolor();
}
enum Color implements Incolor{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");
    private String title;
    private Color(String title){
        this.title = title;
    }
    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getcolor(){
        return this.title;
    }
}
public class Meiju {
    public static void main(String[] args) {
        System.out.println(Color.BLUE);
        for(Color temp : Color.values()){//values（）方法返回的是一个枚举的对象数组
            System.out.println(temp.ordinal() + "=" + temp.name());
        }
        Incolor incolor = Color.BLUE;
        System.out.println(incolor.getcolor());
    }
}
// 准确覆写 @Override   警告声明过期 @Deprecated   //压制警告@SuppressWarnings
