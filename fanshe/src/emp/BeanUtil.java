package emp;

import java.lang.reflect.Method;

//操作简单类属性设置的工具类
public class BeanUtil {
   private BeanUtil(){

   }

    /**
     *
     * @param actionObj 拿到提供给用户使用的xxAction方法
     * @param beaenValue 要设置的具体值
     */// "emp.name:guoxiaogang|emp.job:Coder";
   public static void setBeanValue(Object actionObj,String beaenValue)throws Exception{
       //1.第一步拆分
        String[] temp = beaenValue.split("\\|");
        for(int i = 0; i < temp.length; i++){
            //emp.name:guoxiaogang
            //emp.job:Coder
            String[] result = temp[i].split(":");
            //emp.name
            //guoxiaogang
            String realValue = result[1];//设置的值，第二个元素
            //emp.neme
            String className = result[0].split("\\.")[0];//第一个元素按照 . 拆分，第一个元素为类名
            String attrname = result[0].split("\\.")[1];//第一个元素按照  . 拆分，第二个元素为属性名
            //根据xxAction类取得真正的操作的主题类Emp
            //通过反射调用getEmp()
            Object realobject = getRealObject(actionObj,className);
            //调用正真类的setter方法设置属性值
            //取得真正主题类的class对象
            Class<?> cls = realobject.getClass();
            //拼装setter方法名
            String setName = "set" + initCap(attrname);
            Method setmethod = cls.getMethod(setName,String.class);
            //调用invoke调用反射设置值
            setmethod.invoke(realobject,realValue);
        }
   }

    /**
     * 取得真正操作的对象
     * @param actionObj
     * @param className 要操作的类名称
     * @return
     */
   private static Object getRealObject(Object actionObj,String className)throws Exception{
       //1.取得xxAction Class对象
       Class<?> cls = actionObj.getClass();
       //2.拼装getxx()方法
       String methodName = "get" + initCap(className);
       //3.取得该方法的名称的Method对象
       Method method = cls.getMethod(methodName);
       //4.通过反射调用该方法
       // 等同于empAction.getEmp();
       return method.invoke(actionObj);
    }
    private static String initCap(String str){
       return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
