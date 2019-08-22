package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtils {
    private static final Gson gson = new GsonBuilder().create();
    private CommUtils(){

    }

    /**
     * 根据指定的文件名加载配置文件
     * @param filename 配置文件名
     * @return
     */
    public static Properties LoadProperties(String filename){
        Properties properties = new Properties();
        //获取当前配置文件文件夹下的文件输入流
        InputStream inputStream = CommUtils.class.getClassLoader().getResourceAsStream(filename);
        //加载配置文件中的所有内容
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static String object2Json(Object obj){
        return gson.toJson(obj);
    }
    public static Object josn2Object(String jsonStr,Class objClass){
        return gson.fromJson(jsonStr,objClass);
    }
    public static boolean strIsNull(String str){
        return str == null || str.equals("");
    }
}
