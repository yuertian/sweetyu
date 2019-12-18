<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/31
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div id="top"><span style="color:red">${regerrors}</span></div>
<form id="login" action="/servlet/RegisterUserServlet" method="post">
    用户名:<input type="text" name="username"/><br>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" /><br>
    <span style="color:red">注意:用户名和密码长度最低6位,且不得超过18位!</span><br>
    <input type="submit" value="确定">
    <input type="reset" value="重置">
</form>

</body>
</html>
