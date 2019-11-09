package tianyu;

package XATU_DuanU;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.css.Counter;

import com.sun.org.apache.bcel.internal.generic.StackConsumer;

public class Myservlet_1 extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Integer i; // ȫ�ֱ���

    @Override
    public void init() throws ServletException {
        /**
         * ��ʼ����������ֵΪ 1
         */
//		ServletContext sum = getServletContext();
//		sum.setAttribute("times", 1);
        i = 1;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=utf-8"); // �����������
        PrintWriter out = resp.getWriter(); // new���������
        out.write("<h1 style='color:#00BFFF'>���ǵ�" + i + "������</h1>");
        System.out.println(i);
        i++;




//		ServletContext sum = getServletContext();   //�õ�getServletContext����
//		Integer times = (Integer) sum.getAttribute("times"); //��ServletContext��ü���������
//		System.out.println("������" + times + "��");
//		 sum.setAttribute("times", times + 1);       //Ϊ�������� 1
//		out.write("<h1 style='color:#00BFFF'>���ǵ�" + times + "������</h1>");  //���������������ʴ���

    }

}
