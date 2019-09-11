package com.gxg;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       List list = new ArrayList();
       List list1 = new ArrayList();
       list1.add(2);
       list.add(1);
       list.addAll(list1);
        System.out.println(list);
        System.out.println(list.get(1));

    }
}
