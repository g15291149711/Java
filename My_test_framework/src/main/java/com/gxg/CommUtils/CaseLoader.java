package com.gxg.CommUtils;

import com.gxg.Case;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CaseLoader {
    public CaseRunner load() throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        String pkgdot = "com.gxg.cases";
        String pkg = "com/gxg/cases";
        List<String> classNameList = new ArrayList<String>();
        //1.根据一个固定类，找到类加载 器
        //2.根据类加载器找到类文件的路径
        //3.扫描路径的所有类文件
        ClassLoader classLoader = this.getClass().getClassLoader();
            Enumeration<URL> urls = classLoader.getResources(pkg);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (!url.getProtocol().equals("file")) {
                    //如果不是*.class文件，暂时不支持
                    continue;
                }
                //URL解码
                String dirname = URLDecoder.decode(url.getPath(), "UTF-8");
                File dir = new File(dirname);
                if (!dir.isDirectory()) {
                    //不是目录
                    continue;
                }
                File[] files = dir.listFiles();
                if (files == null) {
                    continue;
                }
                for (File file : files) {
                    String filename = file.getName();
                    String className = filename.substring(0, filename.length() - 6);
                    classNameList.add(className);
                }
            }
            List<Case> caseList = new ArrayList<Case>();
            //通过反射取出实现Case接口的类，就是需要测试的类
            for (String className : classNameList) {
                Class<?> cls = Class.forName(pkgdot + "." + className);
                if (hasInterface(cls, Case.class)) {
                    caseList.add((Case) cls.newInstance());
                 }
            }
            return new CaseRunner(caseList);
     }
    private boolean hasInterface(Class<?> cls,Class<?> interfce){
            Class<?>[] interf = cls.getInterfaces();
            for(Class<?> i : interf){
             if(i == interfce){
                 return true;
             }
         }
         return false;
    }
}
