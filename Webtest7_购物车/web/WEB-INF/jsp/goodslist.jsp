<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="edu.entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/30
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品清单</title>
</head>
<body>
当前登录用户:${username}<br/>
欢迎选购商品!<br/>
<%
    HashMap allgoods = (HashMap) session.getAttribute("allgoods");
%>

    <table border="1">
        <tr>
            <td>商品号</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>操作</td>
        </tr>
        <%
            Set set = allgoods.keySet();    //得到map的键集合
            Iterator it= set.iterator();

            while(it.hasNext()){
                int gid = (int) it.next();  //遍历map的每一个键
                Goods goods = (Goods) allgoods.get(gid);//根据键得到每个对应的对象value
        %>
            <tr>
                <td><%=goods.getGid()%></td>
                <td><%=goods.getGname()%></td>
                <td><%=goods.getPrice()%></td>
                <td><a href="/buyForm.jsp?gid=<%=gid%>">购买</a></td>

            </tr>
        <%
            }
        %>
    </table>
<a href="/showCar.jsp">查看购物车</a>
<a href="/servlet/ExitServlet">退出登录</a><br/>
<a href="/chains.jsp">不买东西?来玩成语接龙</a><br>
<a href="/computer.jsp">计算器</a>


</body>
</html>
