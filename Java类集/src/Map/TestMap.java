package Map;

import java.util.*;

public class TestMap {
    public static void code1(){
        Map<Integer,String> map = new Hashtable<>();
        map.put(1,"Hello");
        map.put(2,"sadf");
        map.put(3,"bit");
        map.put(4,"lalal");
        //取得当前Map中所有key值
        Set<Integer> set = map.keySet();
        Iterator<Integer> integer = set.iterator();
        while(integer.hasNext()){
            System.out.println(integer.next());
        }
        System.out.println(map.get(3));
        System.out.println(map.get(1));
        //取得当前Map中所有Value值
        for(Integer i : set){
            System.out.println(map.get(i));
        }
    }
    public static void main(String[] args) {
         Map<Integer,String> map = new HashMap<>();
         map.put(1,"张三");
         map.put(2,"李四");
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
