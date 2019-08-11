package Fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

//反射调用普通方法
class Persono{
    private String name;

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Test2 {
    public static void main(String[] args) throws Exception {
        //1.取得Class对象
         Class<Persono> cls = Persono.class;
        //2.组装方法名称
        String setMethodName = "set" + print("name");
        String getMethodName = "get" + print("name");
        //3.取得Method对象
        Method setMethod = cls.getMethod(setMethodName,String.class);
        Method getMethod = cls.getDeclaredMethod(getMethodName);
        getMethod.setAccessible(true);
        //4.取得Persono类的实例化对象而后调用普通方法
        Persono per = cls.newInstance();
        System.out.println(setMethod.invoke(per,"zhangsan"));
        System.out.println( getMethod.invoke(per));

    }
    private static String print(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
