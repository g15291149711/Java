package com.gxg.cases;

import com.gxg.Case;
import com.gxg.annotations.Benchmark;
import com.gxg.annotations.Measurement;

@Measurement(iteration = 5,Group = 5)
public class StringConcatCase implements Case {
    @Benchmark
    public static void addString(){
        String str = "";
        for(int i = 0; i < 10; i++){
            str += i;
        }
    }
    @Benchmark
    public static void addStringBuilder(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(i);
        }
    }
}
