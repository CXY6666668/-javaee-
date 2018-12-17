package cn.yjpt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.User;
import cn.yjpt.dao.UserDao;
import cn.yjpt.dao.service.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
         this.doPost(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	request.setCharacterEncoding("utf-8");
	 * ��ȡ�ͻ����ύ�ı�����
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
//		�õ�session����
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("usertypes", usertypes);
		response.setContentType("text/html;charset=utf-8");
		*/
		//PrintWriter out=response.getWriter();
//		out.println("<html><head>");
//		out.println("<title>��¼����</title>");
//		out.println("</head>");
//		out.println("<boby>");
//		if("admin".equals(usertype)) {
//			if(("12".equals(username))&&("123".equals(password))){
//				out.println("��ӭ����Ա"+username+"��¼�ɹ�");
//			}else {
//				out.println("����Ա"+username+"�û��������벻��ȷ");
//			}
//		}
//		if("company".equals(usertype)) {
//			if(("����".equals(username))&&("1234".equals(password))) {
//				out.println("��˾"+username+"��¼�ɹ�");
//			}else {
//				out.println("��˾"+username+"�û��������벻��ȷ");
//			}
//		}
//		if("student".equals(usertype)) {
//			if(("����".equals(username))&&("111".equals(password))) {
//				out.println("��ӭѧ��"+username+"��¼�ɹ�");
//			}else {
//				out.println("ѧ��"+username+"�û��������벻��ȷ");
//			}
//		}
//		out.println("</boby>");
//		out.println("</html>");
//		out.flush();
//		out.close();
		/*
		 * 
		 * 
		 * ��ȡ�ͻ����ύ�ı�����
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
//		�õ�session����
		HttpSession session=request.getSession();
//		���û������û����ͷ�װ��session��
		session.setAttribute("username", username);
		session.setAttribute("usertypes", usertypes);
//		��֤�û��������룬�û������Ƿ����
		if(username==null||username.trim().equals("")) {
			response.sendRedirect("/xyjygl/error");
			return;
		}
		if(password==null||password.trim().equals("")) {
			response.sendRedirect("/xyjygl/error");
			return;
			
		}
		response.sendRedirect("/xyjygl/success");*/
	
		
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC\"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html><head>");
		out.println("<title>��¼����</title>");
		out.println("</head>");
		out.println("<boby>");
		//��ȡ��ǰHttpSession ����
		HttpSession session=request.getSession();
//		��ȡ�û��ύ�ı�����
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
	//	String verify = request.getParameter("verify");
//		������ȡ���û�����ֵ������һ��User����
		User user=new User();
//		����ȡ�ı���������user���������ֵ
		user.setUsername(username);
		user.setPassword(password);
		user.setUsertypes(usertypes);
	//	user.setVerify(verify);
//		����UserDao����������ѯ�û����ݿ��Ƿ����
		UserDao ud=new UserDaoImpl();
		User u=ud.lookUser(user);
//		System.out.print(u.getVerify());
		
//		����û������ݿ��д��ڣ���ô����u��usertypes���Բ���error
		if(u.getUsertypes().equals("error")){
//			˵���û�����
			//out.println("�û��������벻����");
			//�������������������ֵ
			request.setAttribute("errorMsg", "�û��������벻����");
//			ת���ص�¼ҳ��
			this.gotoPage("public/login.jsp",request,response);
		}else{//�û�����
			if(u.getVerify().equals("1")){
				//out.println("�û�δ�������ϵ����Ա");
				request.setAttribute("errorMsg", "�û�δ�������ϵ����Ա");
				this.gotoPage("public/loign.jsp", request, response);
			}
//			˵���û���ͨ�����
			if(u.getVerify().equals("2")){
				//�ѵ�ǰ�û���װ��session������
				session.setAttribute("user", u);
//				�ж��û����
				if(u.getUsertypes().equals("student")){
					//out.println("��ӭѧ��:"+user.getUsername()+"��¼");
					this.gotoPage("stu/stuindex.jsp", request, response);
				}
				if(u.getUsertypes().equals("company")){
					//out.println("��ӭ��˾:"+user.getUsername()+"��¼");
					this.gotoPage("company/companyindex.jsp", request, response);
				}
				if(u.getUsertypes().equals("admin")){
					//out.println("��ӭ����Ա:"+user.getUsername()+"��¼");
					this.gotoPage("admin/index.jsp", request, response);
				}
			}
			if(u.getVerify().equals("3")){
				//out.println("�û����δͨ����������ע�ᣬ��ʵ��д��Ϣ");
				this.gotoPage("admin/index.jsp", request, response);
			}
			out.println("</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		
		
	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
