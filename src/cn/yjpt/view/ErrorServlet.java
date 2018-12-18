package cn.yjpt.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ErrorServlet
 */

public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		String username = (String) request.getParameter("username");
		// String password1=(String)request.getParameter("password1");
		// String password2=(String)request.getParameter("password2");
		String usertypes = (String) request.getParameter("usertypes");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLC\"-//W3C//DTD HTML4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<BODY>");
		out.println(usertypes + "’ ∫≈:" + username + "◊¢≤·–≈œ¢¥ÌŒÛ£°");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
