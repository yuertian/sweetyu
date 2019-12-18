<%@ page import="edu.entity.Computer" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/28
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page errorPage="/zero.jsp" %>
<html>
<head>
    <title></title>
</head>
<body
>
<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String[] oper = request.getParameterValues("oper");
    Computer computer = new Computer(); //实例化计算器
    double result = 0;
    if(Double.parseDouble(num2)==0 && oper[0].equals("/")){
        request.setAttribute("numError","除数不能为0!");
        //response.sendRedirect("computer.jsp");
        request.getRequestDispatcher("/computer.jsp").forward(request, response);
    }else{

        switch (oper[0]){
            case "+":
                result = computer.getAdd(Double.parseDouble(num1),Double.parseDouble(num2));
                break;
            case "-":
                result = computer.getSub(Double.parseDouble(num1),Double.parseDouble(num2));
                break;
            case "*":
                result = computer.getMul(Double.parseDouble(num1),Double.parseDouble(num2));
                break;
            case "/":
                result = computer.getDiv(Double.parseDouble(num1),Double.parseDouble(num2));
                break;
            default:
                System.out.println("符号错误!");
                break;
        }
    }
    request.setAttribute("result",result);
    request.getRequestDispatcher("/computer.jsp").forward(request, response);

%>

</body>
</html>
