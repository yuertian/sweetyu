<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/4/22
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <%
        // 判断cookie是否有username，如果有代表登陆过
        boolean flag = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) { // 表明已经登陆过了，就直接跳转了
                    flag = true;
                }
            }
        }
        if(flag){
            response.sendRedirect("/servlet/SelectServlet");
        }
    %>
</head>
<body>
<div id="top"><span style="color:red">${mesg}</span></div>
<div id="top"><span style="color:red">${errors}</span></div>
<form id="login" action="/servlet/LoginServlet" method="post">
    用户名:<input type="text" name="username"/><br>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" /><br>
    7天免登录<input type="checkbox" name="cook">
    <input type="submit" value="确定">
    <input type="reset" value="重置">
    </form>
<a href="/register.jsp">尚未注册?请点击</a>
</body>
</html>
