package TestJVM;
//循环引用问题
class Test{
    private byte[] bigsize = new byte[1024 * 1024 * 2];
    public Object instance = null;
}
//  JVM参数 - XX:+PrintGC
public class TestGC {
    public static void main(String[] args) {
        Test test1 = new Test();// 2m byte[]  instance -> null
        Test test2 = new Test();// 2m byte[]  instance -> null
        test1.instance = test2;// -> 堆上的对象
        test2.instance = test1;// -> 堆上的对象
        test1 = null;//test1 不在引用堆上的对象
        test2 = null;//test2 不在引用堆上的对象
        //堆上的对象   等待  垃圾回收器回收
        System.gc();//强制gc
    }
}
