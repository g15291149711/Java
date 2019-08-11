package annotation;

import java.lang.annotation.Annotation;

@Deprecated
@SuppressWarnings("serial")
public class TestAnnotation {
    public static void main(String[] args) {
        Annotation[] annotations = TestAnnotation.class.getAnnotations();//取得全部注解
        for(Annotation annotations1 : annotations){
            System.out.println(annotations1.annotationType().getName() + " " +annotations1.toString());
            Annotation annotation = TestAnnotation.class.getAnnotation(Deprecated.class);//取得指定注解
            System.out.println(annotation.toString());
        }
    }
}
