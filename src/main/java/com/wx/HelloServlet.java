package com.wx;

import com.wx.entity.bo.HeadLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    Logger log = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void init(){
        System.out.println("初始化Servlet...");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("是我执行了doGet方法，我才是入口");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "我的简易框架！";
        req.setAttribute("name",name);
        log.debug(name);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
        HeadLine headLine = new HeadLine();
        headLine.setLineId(1l);
        headLine.getLineId();
    }

    @Override
    public void destroy(){
        System.out.println("destroy...");
    }

}
