package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void code1(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Java","C++");
        list.forEach((s) -> System.out.println(s));
        list.forEach(System.out::println);
        //匿名内部类的对象
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
    public static void code2(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Java","C++","JavaScrip","python");
        System.out.println(list.size());
        //计算包含java的数据
        Stream<String> stream = list.stream();
        System.out.println(stream.filter((e) ->e.contains("Java")).collect(Collectors.toList()));
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1.Java","2.C++","3.JavaScrip","4.python");
        //跳过俩个取俩个
        List<String> list1 =  list.stream().skip(2).limit(2).collect(Collectors.toList());
        System.out.println(list1);

    }
}
