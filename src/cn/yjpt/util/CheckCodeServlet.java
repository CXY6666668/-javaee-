package cn.yjpt.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCodeServlet() {
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
		// ȡ���������code��ֵ
		String checkcode = request.getParameter("code");
		// ȡ��session�з�װ��������Ϊcode������ֵ
		HttpSession session = request.getSession();
		String sessioncode = String.valueOf(session.getAttribute("code"));
		// 3.�ж��������ֵ�ͻỰ����ֵ�Ƿ���ͬ
		if (checkcode.toLowerCase().equals(sessioncode.toLowerCase())) {// ��֤�벻���ִ�Сд(toLowerCase())
			// �����ͬ��˵���û�������֤����ȷ������ת����urlΪlogin��servlet����
			this.gotoPage("login", request, response);
		} else {
			request.setAttribute("codeMsg", "��֤�����");
			this.gotoPage("public/login.jsp", request, response);
		}

	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
