package calssLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//N个接口，N个真实类，N个代理类
//动态代理： N个接口，N个真实类，一个代理类
interface Isubject{
    void eat(String name,int count);
}
class RealSubject implements Isubject{
    public void eat(String name,int count){
        System.out.println("eat" + count + "两" + name);
    }
}
class ProxySubject implements InvocationHandler{
    private Object object;

    /**
     * 将真实接口与代理类绑定
     * @return 返回绑定好的代理类对象
     */
    public Object bind(Object realObject){
        this.object = realObject;
        //绑定接口子类对象
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
    public void before(){
        System.out.println("before handle");
    }
    public void after(){
        System.out.println("after hamdle");
    }
    /**
     *
     * @param proxy 代理类对象
     * @param method 真实业务方法
     * @param args 真实方法入参
     * @return 真实接口对象
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();;
        Object obj = method.invoke(this.object,args);
        this.after();
        return obj;
    }
}
public class dailimoshi {
    public static void main(String[] args) {
            Isubject isubject = (Isubject) new ProxySubject().bind(new RealSubject());
            isubject.eat("啦啦啦啦",55);
    }
}
