package edu.servlet;

import edu.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "RemoveFromCarServlet",urlPatterns = "/servlet/RemoveFromCarServlet")
public class RemoveFromCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String gid = req.getParameter("gid");
        HashMap goodsCar = (HashMap) req.getSession().getAttribute("goodsCar");
        Goods goods = (Goods) goodsCar.get(Integer.parseInt(gid));

        //总钱数减少

        //从购物车中移除相应商品
        goodsCar.remove(goods.getGid());
      //  req.getSession().setAttribute("goodsCar",goodsCar);
        req.getRequestDispatcher("/showCar.jsp").forward(req,resp);

    }
}
