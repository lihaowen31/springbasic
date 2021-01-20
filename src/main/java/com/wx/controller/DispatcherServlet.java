package com.wx.controller;

import com.wx.controller.frontend.MainPageController;
import com.wx.controller.superadmin.HeadLineOperationController;
import com.wx.entity.dto.MainPageInfoDTO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 减少Servlet的数量,创建一个DispatcherServlet类进行请求派发,做了如下三件事：
 *  1.拦截所有请求
 *  2.解析请求
 *  3.派发给对应的Controller里面的方法进行处理
 *
 * @WebServlet说明
 * 如果@WebServlet的内容为@WebServlet("/*"),则表示拦截所有请求,此时使用如下代码：
 * req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
 * 跳转至jsp的请求也会被拦截,所以会不停的循环调用该Servlet中的service方法,最终抛出异常.
 * 而如果使用@WebServlet("/")，则不会拦截对jsp的请求，即如果请求路径的后缀为 .jsp， 则不会进行拦截
 * 具体原因需要查看tomcat的配置web.xml中有如下内容：
 *     <servlet-mapping>
 *         <servlet-name>default</servlet-name>
 *         <url-pattern>/</url-pattern>
 *     </servlet-mapping>
 *
 *     <servlet-mapping>
 *         <servlet-name>jsp</servlet-name>
 *         <url-pattern>*.jsp</url-pattern>
 *         <url-pattern>*.jspx</url-pattern>
 *     </servlet-mapping>
 *  在servlet-mapping中，default匹配的优先级最低，而/*仅次于精确匹配
 *
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        //解析请求
        System.out.println("request path is:" + req.getServletPath());
        System.out.println("request method is:" + req.getMethod());
        //请求转发
        if(req.getServletPath() == "/frontend/getmainpageinfo" && req.getMethod() == "GET"){
            new MainPageController().getMainPageInfo(req, resp);
        }else if(req.getServletPath() == "/superadmin/addheadline" && req.getMethod()=="POST"){
            new HeadLineOperationController().addHeadLine(req, resp);
        }
    }
}
