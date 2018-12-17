package cn.yjpt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		Cookie allcookies[]=request.getCookies();
		Cookie ck=null;
		for(int i=0;allcookies!=null&&i<allcookies.length;i++) {
			String name=allcookies[i].getName();
			if("jygl".equals(name)) {
				ck=allcookies[i];
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1>");
		out.println("欢迎光临我们的系统:");
		
		if(ck!=null) {
			int  n=Integer.parseInt(ck.getValue())+1;
			ck.setValue(n+"");
			ck.setMaxAge(15*24*60*60);
			response.addCookie(ck);
			out.println("这是你的第"+n+"次登录！");
		}
		else {
			Cookie cookie=new Cookie("jygl","1");
			cookie.setMaxAge(30*20*60*60);
			response.addCookie(cookie);
			out.println("这是你的第一次登录");
		}
	out.println("<h1>");
	out.println("</body>");
	out.println("</html>");
	out.flush();
	out.close();
	}
	
	public void init()throws ServletException{
		
	}

}
