<%@ page import="java.util.HashMap" %>
<%@ page import="edu.entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/30
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前登录用户:${username}<br/>
<%
    String gid = request.getParameter("gid");//接收点击购买的url返回的参数
    HashMap allgoods = (HashMap) session.getAttribute("allgoods");
    Goods goods = (Goods) allgoods.get(Integer.parseInt(gid));
%>
欢迎购买:<%=goods.getGname()%>
<form action="/servlet/AddGoodsToCarServlet" method="post">
    商品单价:<%=goods.getPrice()%><br>

    <%--使用隐藏表单向AddGoodsToCarServlet提交数据--%>
    <input type="hidden" name="gid" value="<%=goods.getGid()%>">
    <input type="hidden" name="gname" value="<%=goods.getGname()%>">
    <input type="hidden" name="price" value="<%=goods.getPrice()%>">

    数量:
    <input name="number" type="text">
    <input type="submit" value="购买">
</form>
<a href="/servlet/SelectServlet">取消购买</a>


</body>
</html>
