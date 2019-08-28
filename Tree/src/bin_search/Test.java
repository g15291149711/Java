package bin_search;


import com.sun.scenario.effect.impl.HeapImage;

import java.util.ArrayList;
import java.util.Scanner;
public class Test{

    public static void main(String[] args) {
        Ibin_serch<Integer> integerIbin_serch = new TestBinsearchTree<>();
        int[] data = new int[]{4,5,3,2,8};
        for(int i = 0; i < data.length; i++){
            integerIbin_serch.add(data[i]);
        }
       /* integerIbin_serch.preOrder();
        integerIbin_serch.inOrder();
        integerIbin_serch.postOrder();*/

        integerIbin_serch.inOrder();
    }
}