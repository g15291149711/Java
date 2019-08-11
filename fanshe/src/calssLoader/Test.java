package calssLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface Isubject2{
    public void buyComputer();
}
class RealS implements Isubject2{

    @Override
    public void buyComputer() {
        System.out.println("我要买充气娃娃");
    }
}
class ProxyS implements InvocationHandler{
    private Object target;



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}
public class Test {
    public static void main(String[] args) throws Exception{

    }
}
