<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/14
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="top"><span style="color:green">转换成功!</span></div>

<form action="/numberFormat.jsp" method="post">
请输入要转换的数据:<input type="text" name="number"><br>
请选择要转换的数据类型:
<select multiple="multiple" name="numType">
    <option value="int">int</option>
    <option value="double">double</option>
    <option value="String">String</option>
</select>
    <input type="submit" value="确定">
</form>
</body>
</html>
