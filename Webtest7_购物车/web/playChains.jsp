<%@ page import="edu.dao.IdiomDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/14
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    IdiomDao idiomDao = new IdiomDao();
    // 获取表单传来的参数
    String idiom = request.getParameter("idiom");


    if (idiom.length() < 4) {
        request.setAttribute("idiomError", "请输入成语！");
        request.getRequestDispatcher("/chains.jsp").forward(request, response);
        //response.sendRedirect("/chains.jsp");
    }
    StringBuilder sb= (StringBuilder) request.getAttribute("idioms");
    sb.append(idiom+"-->");

    // 匹配成语的最后一个字
    List<String> repIdiom = idiomDao.getIdiom(idiom.charAt(idiom.length() - 1) + "");
    // 将成语最后一个字保留在session中
    request.getSession().setAttribute("lastIndex", idiom.charAt(idiom.length() - 1) + "");
    //out.println(idiom);
    // out.println(idiom.charAt(idiom.length()-1)+"");

    //随机匹配一个成语
    String randomIdiom = repIdiom.get(new Random().nextInt(repIdiom.size()));
    sb.append(randomIdiom+"-->");
    //out.println(randomIdiom);
    request.setAttribute("randomIdiom", randomIdiom);
    request.setAttribute("meanIdiom", "点击查看-->" + randomIdiom + "<--释译");
    request.getSession().setAttribute("idioms",sb);
    request.getRequestDispatcher("/chains.jsp").forward(request, response);

%>

</body>
</html>
