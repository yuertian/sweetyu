<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/14
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>欢迎来到成语接龙</title>
</head>
<body>
<div id="top"><span style="color:green">${idioms}</span></div>
<div id="top"><span style="color:red">${idiomError}</span></div>
<div id="top"><span style="color:orangered">${randomIdiom}</span></div>
<a href="https://hanyu.baidu.com/s?wd=${randomIdiom}&from=zici">${meanIdiom}</a>
<form action="/playChains.jsp" method="post">
    请输入一个成语:<input type="text" name="idiom"><br>
    <input type="submit" value="确定">
</form>

</body>
</html>
