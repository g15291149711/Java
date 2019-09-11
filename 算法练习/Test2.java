package com.gxg;

import java.util.ArrayList;
public class Test2 {
    public void reOrderArray(int [] array) {
        if(array.length == 0){
            return;
        }
        ArrayList<Integer>  list1 = new ArrayList<>();
        ArrayList<Integer>  list2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 1){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }

        list1.addAll(list2);
        for(int i = 0; i < array.length; i++){
            array[i] = list1.get(i);
        }
    }
}