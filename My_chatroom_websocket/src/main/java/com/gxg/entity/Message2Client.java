package com.gxg.entity;

import lombok.Data;

import java.util.Map;

//后端发送给前端的信息实体
public class Message2Client {
    //聊天内容
    private String content;
    //服务端登录的所有用户列表

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setContent(String userName,String msg){
        this.content = userName + "说" + msg;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    private Map<String,String> names;
}
