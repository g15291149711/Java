package zhanyuduili;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","A","B");
        System.out.println(list);
        Collections.sort(list);
        for(String str : list){
            System.out.println(str);
        }
        Collections.reverse(list);
        for(String s : list){
            System.out.println(s);
        }
    }
}
