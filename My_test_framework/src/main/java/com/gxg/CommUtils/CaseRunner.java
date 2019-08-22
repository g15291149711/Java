package com.gxg.CommUtils;

import com.gxg.Case;
import com.gxg.annotations.Benchmark;
import com.gxg.annotations.Measurement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CaseRunner {
        private static final int DEFAULT_ITERATIONS = 10;
        private static final int DEFAULT_GROUP = 10;

        private final List<Case> caseList;
        public CaseRunner(List<Case> caseList){
            this.caseList = caseList;
        }
        public void run(){
            //找到对象中那些方法是需要测试的方法
            for(Case bCase : caseList){
                System.out.println(caseList);
                int iterations = DEFAULT_ITERATIONS;
                int group = DEFAULT_GROUP;

                //先获取类级别的配置
                Measurement classMeasuremennt = bCase.getClass().getAnnotation(Measurement.class);
                if(classMeasuremennt != null){
                    iterations = classMeasuremennt.iteration();
                    group = classMeasuremennt.Group();
                }
                Method[] methods = bCase.getClass().getMethods();
                for(Method method : methods){
                    Benchmark benchmark = method.getAnnotation(Benchmark.class);
                    if(benchmark == null){
                        continue;
                    }
                    Measurement methodmeasurement = method.getAnnotation(Measurement.class);
                    if(methodmeasurement != null){
                        iterations = methodmeasurement.iteration();
                        group = methodmeasurement.Group();
                    }
                    runCase(bCase,method,iterations,group);
                }
            }
        }
        private void runCase(Case bCase,Method method,int iterations,int group){
            System.out.println(method.getName());
            for(int i = 1; i <= group; i++){
                System.out.println("第" + i + "次实验");
                long t1 = System.nanoTime();
                for(int j = 1; j < iterations; j++){
                    try {
                        method.invoke(bCase);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                long t2 = System.nanoTime();
                System.out.println("耗时：" + (t2 - t1) + "纳秒");
            }
        }
}
