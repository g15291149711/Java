package javatalkhouse;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TestThreadServer {
    public static void main(String[] args) throws IOException {
        //1.取得客户端对象建立连接
      Socket socket = new Socket("127.0.0.1",6666);
      //2.进行数据输入输出
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("服务器发出的信息为：" + scanner.nextLine());
        }
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("你好我是客户端");
        //3.关闭流
        printStream.close();
        scanner.close();
        socket.close();
    }
}
