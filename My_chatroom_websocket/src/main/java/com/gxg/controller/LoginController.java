package com.gxg.controller;


import com.gxg.config.FreeMarkerListener;
import com.gxg.service.AccountService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import utils.CommUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    List<String> list = new ArrayList<>();
    private AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        if (CommUtils.strIsNull(userName) || CommUtils.strIsNull(password)) {
            // 登录失败,停留登录页面
            out.println("    <script>\n" +
                    "        alert(\"用户名或密码为空!\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
        if (accountService.userLogin(userName,password)) {
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                System.out.println("dsasadsd");
                String str = iterator.next();
                System.out.println(str);
                if(userName.equals(str)){
                    System.out.println("dsafsfdafdsaasdfa");
                    out.println("    <script>\n" +
                            "        alert(\"用户已经登录!\");\n" +
                            "        window.location.href = \"/index.html\";\n" +
                            "    </script>");
                    break;
                }
            }
            // 登录成功,跳转到聊天页面
            // 加载chat.ftl
            Template template = getTemplate(req,"/chat.ftl");
            Map<String, String> map = new HashMap<>();
            map.put("username",userName);
            try {
                template.process(map, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            list.add(userName);
                System.out.println(list);
        }else {
            // 登录失败,停留在登录页面
            out.println("    <script>\n" +
                    "        alert(\"用户名或密码不正确!\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private Template getTemplate(HttpServletRequest req,String fileName) {
        Configuration cfg = (Configuration)
                req.getServletContext().getAttribute(FreeMarkerListener.TEMPLATE_KEY);
        try {
            return cfg.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
