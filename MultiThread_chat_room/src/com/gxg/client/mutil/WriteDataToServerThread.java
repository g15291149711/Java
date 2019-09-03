package com.gxg.client.mutil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteDataToServerThread extends Thread{
    private final Socket socket;

    public WriteDataToServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(System.in);//控制台
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            while(true){
                System.out.print("请输入>");
                String message = scanner.nextLine();
                printStream.println(message);
                if("quit".equals(message)){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
