package huminmio.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//浏览器访问/login这个路径时，就可以执行servlet中的service方法
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);

        //设置编码及响应类型，在servlet中都要进行设置
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");//设置响应体
        //设置浏览器解析的类型：响应头Content-Type值
        resp.setContentType("text/html; charset=UTF-8");

        //获取请求数据，通过键获取值，如果获取不到，值就为null
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("username=%s,password=%s", username, password);

        //响应数据给客户端
        PrintWriter pw = resp.getWriter();
        pw.println("<p>用户名：" + username + "，密码：" + password + "</p>");
        pw.flush();
    }
}
