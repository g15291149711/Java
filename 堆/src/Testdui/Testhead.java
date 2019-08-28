package Testdui;

import java.util.*;

public class Testhead {
    private String ab;
    public static void main(String[] args) {
        //模式    String     try catch finally
        String s = "a";
        test(s);
        System.out.println(s);
    }
    public static void test(String string){
         List<Integer> list = new ArrayList<>();
         list.add(1);
         list.add(2);
        System.out.println(list.size());
    }
}
