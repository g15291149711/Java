package Map;

import java.util.*;

public class Testiterator {
    public static void main(String[] args) {
   /*     List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C","A");
        // moedCount = 6
        Iterator<Strin//expectedModeCount = 6;g> iterator =
                //取得集合迭代器

                list.iterator();
        while(iterator.hasNext()){
            //调用checkForComodification检查当前副本中的expectedModeCount是否等于集合的ex...
            String str = iterator.next();
            if(str.equals("B")){
                //list.remove()方法错误
                iterator.remove();
                continue;
            }
            System.out.println(str);
        }*/
   List<String> list = new ArrayList<>();
   Collections.addAll(list,"a","b","c","d");
   Iterator<String> iterator = list.iterator();
   while(iterator.hasNext()){
       String str = iterator.next();
   }
        //取得ArrayList迭代器
        //双向迭代器，要想从后往前遍历，必须先从前往后遍历一次
       /* ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }*/
       //Verctor专有的迭代器接口
       /* Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("dsa");
        Enumeration<String> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }*/
    }
}
