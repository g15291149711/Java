package sort;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            fun(s);
        }
    }
    public static void fun(String s){
        char[] data = s.toCharArray();
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            char c = data[i];
            if('A' <= c) {
                c = (char) ('E' < c ?  c - 5 : c + 21);
            }
            arr[i] = c;
        }
        System.out.println(new String(arr));
    }
}
