package edu.servlet;

import edu.entity.Goods;
import edu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "AddGoodsToCarServlet",urlPatterns = {"/servlet/AddGoodsToCarServlet"})
public class AddGoodsToCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        User user = (User) req.getSession().getAttribute("user");

        //初始化购物车
        HashMap goodsCar = (HashMap) req.getSession().getAttribute("goodsCar");

        //获取buyForm表单提交的参数
        String gid  = req.getParameter("gid");
        String gname = req.getParameter("gname");
        String price = req.getParameter("price");
        String number = req.getParameter("number");

        // 如果购物车为空，则创建一个购物车，并添加到Session
        if (goodsCar == null) {
           goodsCar=new HashMap();
           req.getSession().setAttribute("goodsCar",goodsCar);
        }

        //存入购物车中的商品信息
        Goods goods = new Goods();
        goods.setGid(Integer.parseInt(gid));
        goods.setGname(gname);
        goods.setPrice(Double.parseDouble(price));
        goods.setNumber(Integer.parseInt(number));
        goodsCar.put(goods.getGid(),goods);


        req.getRequestDispatcher("/showCar.jsp").forward(req,resp);

    }
}
