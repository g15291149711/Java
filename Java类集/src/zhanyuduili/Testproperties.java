package zhanyuduili;

import java.io.*;
import java.util.Properties;

public class Testproperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
          properties.setProperty("lalala","啦啦啦");
          properties.setProperty("hehehe","呵呵呵");
        System.out.println( properties.getProperty("lalala"));
        System.out.println(properties.getProperty("lilili","默认值"));
        File file = new File("C:\\Users\\郭小港\\Desktop\\新建文件夹\\test.properties");
       properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("lalala"));
        System.out.println(properties.getProperty("hehehe"));
    }
}
