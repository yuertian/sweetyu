<%@ page import="edu.entity.Goods" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/30
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
当前登录用户:${username}<br/>
<table border="1">
    <tr>
        <td>商品号</td>
        <td>商品名称</td>
        <td>商品单价</td>
        <td>购买数量</td>
        <td>操作</td>
    </tr>
    <%
        HashMap goodsCar = (HashMap) session.getAttribute("goodsCar");
        double sum =0;//计算消费总额
        if(goodsCar==null || goodsCar.isEmpty()){
            response.sendRedirect("/nothing.jsp");
        }else{

            Set set = goodsCar.keySet();//得到购物车中所有商品的键集合
            //double sum =0;//计算消费总额
            Iterator it = set.iterator(); //遍历键集合,得到每个键对应的goods对象
            while (it.hasNext()) {
                int gid = (int) it.next();  //遍历map的每一个键
                Goods goods = (Goods) goodsCar.get(gid);//根据键得到每个对应的对象value
                sum+=goods.getPrice()*goods.getNumber();
    %>
    <tr>
        <td><%=goods.getGid()%>
        </td>
        <td><%=goods.getGname()%>
        </td>
        <td><%=goods.getPrice()%>
        </td>
        <td><%=goods.getNumber()%>
        </td>
        <td><a href="/servlet/RemoveFromCarServlet?gid=<%=gid%>">从购物车中删除</a></td>

    </tr>
    <%
            }
        }
    %>
</table>
现金总额:<%=sum%><hr>
<a href="/servlet/SelectServlet">继续购买</a>
<a href="/success.jsp">立即支付</a>

</body>
</html>
