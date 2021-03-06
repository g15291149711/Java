package com.gxg.server.mutil;

import com.gxg.server.mutil.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadServer {
    //支持100client
    //1 thread - > 10client                                                                           给线程起名
    private static final ExecutorService executor = Executors.newFixedThreadPool(10, new ThreadFactory() {
        //给线程名下标
        private final AtomicInteger id = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("Thread-Client-Handler-" + id.getAndIncrement());
            return t;
        }
    });
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务端启动" + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
            while(true){
                final Socket client = serverSocket.accept();
                //使用线程池(选择执行周期和负载能力强的线程池)
                executor.execute(new ClientHandler(client));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
