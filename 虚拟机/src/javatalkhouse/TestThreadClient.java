package javatalkhouse;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestThreadClient {
    public static void main(String[] args) throws IOException {
        //1.建立基站
        ServerSocket server = new ServerSocket(6666);
        //2.等待客户端连接
        System.out.println("等待客户端连接...");
        Socket socket = server.accept();
        //3.建立连接后进行数据的输入输出
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");//拿到输出流
        printStream.println("我是服务端");
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("客户端发来的信息为：" + scanner.nextLine());
        }
        //4.关闭流
        printStream.close();
        scanner.close();
        server.close();
    }
}