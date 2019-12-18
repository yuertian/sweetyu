package edu.servlet;

import edu.dao.UserDao;
import edu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/servlet/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        //获取表单提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cook[] = request.getParameterValues("cook");

        // 判断用户名是否存在
        if (userDao.userIsExit(username) > -1) {
            // 若用户名存在则从数据库中取出该User信息
            User user = userDao.getUser(username);
            // 校验密码
            if (user.getPassword().equals(password)) {
                if (cook != null) {
                    // 若密码正确则将登陆信息存储在cookie中,设置七天免登录
                    Cookie cookie = new Cookie("username", user.getUsername());
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                request.getSession().setAttribute("username", user.getUsername());
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/servlet/SelectServlet");
            } else {
                request.getSession().setAttribute("errors", "密码输入错误！");
                response.sendRedirect("/login.jsp");
            }
        } else {
            request.getSession().setAttribute("errors", "用户名不存在或输入错误！");
            //转回登陆页面
            response.sendRedirect("/login.jsp");
        }
    }

}



