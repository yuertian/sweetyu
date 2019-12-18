package edu.servlet;

import edu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/servlet/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        //获取表单提交的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.length()>=6 && username.length()<=18) {
            if(password.length()>=6 && password.length()<=18){
                if (userDao.createUser(username, password) != 0) {
                    //req.getRequestDispatcher("/regSuccess.jsp").forward(req,resp);
                    resp.sendRedirect("/regSuccess.jsp");
                }
            }else{
                req.getSession().setAttribute("regrrors", "密码格式错误！");
                resp.sendRedirect("/register.jsp");
            }
        }else {
            req.getSession().setAttribute("regerrors", "用户名格式错误！");
            resp.sendRedirect("/register.jsp");
        }
    }
}
