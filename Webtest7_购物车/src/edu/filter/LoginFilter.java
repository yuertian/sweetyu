package edu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =  (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String requestUri = request.getRequestURI();
        System.out.println(requestUri);
        if(request.getSession().getAttribute("username") != null ||
                requestUri.equals("/") ||
                requestUri.equals("/login.jsp")){
            //已登录(或者初始化页面就在login.jsp时)，直接放行,或者让用户登录(不发出提示信息)
            filterChain.doFilter(req, resp);
        }
        else{
            request.setAttribute("mesg","请先登录!");
            request.getRequestDispatcher("/login.jsp").forward(req,resp);
            //response.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

