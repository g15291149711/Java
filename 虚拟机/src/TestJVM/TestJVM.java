package TestJVM;

import java.util.ArrayList;
import java.util.List;

public class TestJVM {
    //OOM异常
    /*static class OOMObject{

    }
    //JVM 程序启动时候通过JVM参数指定最大最小内容
    //:-Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            //循坏一次，在JVM堆上创建一个对象
            list.add(new OOMObject());
        }
*/
   //递归
    //-Xss128k
   private void donstop(){
       donstop();
   }
    public static void main(String[] args) {
        TestJVM testJVM = new TestJVM();
        testJVM.donstop();
    }
}
