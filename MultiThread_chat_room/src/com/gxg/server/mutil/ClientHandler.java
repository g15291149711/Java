package com.gxg.server.mutil;

import javax.naming.ldap.SortKey;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable{
    //Socket
    private final Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    //共享属性
    private static final Map<String,Socket> SOCKET_MAP = new ConcurrentHashMap<>();

    @Override
    public void run() {
        try {
            InputStream inputStream = this.client.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while(true){
                String line = scanner.nextLine();
                if(line.startsWith("register")){
                    //注册流程
                    String[] segments = line.split(":");
                    if(segments.length == 2 && segments[0].equals("register")) {
                        String name = segments[1];
                        register(name);

                    }
                    continue;
                }
                if(line.startsWith("group")){
                    //群聊
                    String[] segments = line.split(":");
                    if(segments.length == 2 && segments[0].equals("group")) {
                        String message = segments[1];
                        groupChart(message);
                    }
                    continue;
                }
                if(line.startsWith("private")){
                    //私聊
                    String[] segments = line.split(":");
                    if(segments.length == 3 && segments[0].equals("private")){
                        String name = segments[1];
                        String message = segments[2];
                        privateChart(name,message);

                    }
                    continue;
                }
                if(line.startsWith("quit")){
                    //退出流程
                    quite();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void quite() {
        //退出
        Iterator<Map.Entry<String,Socket>> iterator = SOCKET_MAP.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Socket> entry = iterator.next();
                if(entry.getValue() == this.client){
                    System.out.println(entry.getKey() + "退出");
                    iterator.remove();
                    break;
                }
            }
            printOnlineClient();
    }

    private void privateChart(String name, String message) {
        //私聊方法
        //谁  给 谁
        Set<Map.Entry<String,Socket>> entrySet = SOCKET_MAP.entrySet();
        String currentName = "";
        for(Map.Entry<String,Socket> entry : entrySet){
            String key = entry.getKey();
            Socket socket = entry.getValue();
            if(socket == this.client){
                currentName = key;
            }
        }
        Socket socket = SOCKET_MAP.get(name);
        if(socket != null){
            this.sendMessage(socket,currentName + "说>" +message);
        }
    }

    private  void register(String name){
        //注册方法
        //name -> socket
        //key -> value
        SOCKET_MAP.put(name,this.client);
        this.sendMessage(this.client,"恭喜" + name + "> 注册成功");
        printOnlineClient();
    }
    private  void groupChart(String message){
        //群聊方法
        //发送消息给当前在线的客户端(不包含自己)
        //谁 发  消息
        Set<Map.Entry<String,Socket>> entrySet = SOCKET_MAP.entrySet();
        String currentName = "";
        for(Map.Entry<String,Socket> entry : entrySet){
            String key = entry.getKey();
            Socket socket = entry.getValue();
            if(socket == this.client){
                currentName = key;
            }
        }
        for(Map.Entry<String,Socket> entry : entrySet) {
            String key = entry.getKey();
            Socket socket = entry.getValue();
            if (socket != this.client) {
                this.sendMessage(socket,currentName + "说>" +message);
            }
        }
    }
    private void sendMessage(Socket socket,String message){
        //发送消息
        try{
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream =  new PrintStream(outputStream);
            printStream.println(message);
            printStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void printOnlineClient(){
        //在线列表
        System.out.println("当前在线的客户端有" + SOCKET_MAP.size() + "名称列表如下：");
        for(String key : SOCKET_MAP.keySet()){
            System.out.println(key);
        }
    }
}
