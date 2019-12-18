<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/28
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算器</title>
</head>
<body>
<div id="top"><span style="color:red">${numError}</span></div>
<form id="login" action="/operation.jsp" method="post">
    第一个参数:<input type="text" name="num1"/><br>
    第二个参数:<input type="text" name="num2" /><br>
    </select>
    选择一种运算:<select multiple="multiple" name="oper" >
    <option value="+">+</option>
    <option value="-">-</option>
    <option value="*">*</option>
    <option value="/">/</option>
</select>
    <input type="submit" value="确定">
    <input type="reset" value="重置">
</form>
计算结果:
<div id="top"><span style="color:orangered">${result}</span></div>
</body>
</html>
