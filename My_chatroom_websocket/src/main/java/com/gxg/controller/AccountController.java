package com.gxg.controller;

import com.gxg.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//加载为servlet类，表单路径
@WebServlet(urlPatterns = "/doRegister")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取表单参数
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter printWriter = resp.getWriter();
        if(accountService.userRegister(userName,password)){
            //用户注册成功，弹框提示，返回登录界面
            printWriter.println("<script>\n" +
                    "    alert(\"注册成功\");\n" +
                    "    //页面跳转\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        }else{
            //弹框提示失败，保留原页面
            printWriter.println("<script>\n" +
                    "    alert(\"注册失败\");\n" +
                    "    //页面跳转\n" +
                    "    window.location.href = \"/registration.html\";\n" +
                    "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
