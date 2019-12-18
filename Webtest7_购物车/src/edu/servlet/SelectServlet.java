package edu.servlet;

import edu.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "SelectServlet",urlPatterns = {"/servlet/SelectServlet"})
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();

        HashMap allgoods = null;    //所有商品的容器
        try {
            allgoods = goodsDao.getAllGoods();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getSession().setAttribute("allgoods",allgoods);
        req.getRequestDispatcher("/WEB-INF/jsp/goodslist.jsp").forward(req,resp);
    }
}
