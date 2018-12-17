package cn.yjpt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yjpt.bean.User;
import cn.yjpt.dao.UserDao;
import cn.yjpt.dao.service.UserDaoImpl;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		/*
		String username=request.getParameter("username");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String usertypes=request.getParameter("usertypes");
		if(password1!=null &&password2!=null&&password1.equals(password2)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("public/login.html");
			dispatcher.forward(request, response);
		}else {
//			������ʾ
			request.setAttribute("username", username);
			request.setAttribute("usertypes", usertypes);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/error");
			dispatcher.forward(request, response);
		}*/
		
		
//		���xUser���󣬌���ֵ��ʼ����Ĭ�Jֵ
		User user=new User();
//		�@ȡ�Ñ��ṩ��ݔ��ֵ
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
//		ʹ������ֵ���ö���user������ֵ
		user.setUsername(username);;
		user.setPassword(password);
		user.setUsertypes(usertypes);
//		ʹ��ݔ��ֵ�O�Ì���u�Č���ֵ
//		����UserDao����
		UserDao ud=new UserDaoImpl();
		/*
//		�z�y�Ñ����Ƿ��ѽ��]��
		boolean flag=ud.checkUsername(username);
		if(flag){
			request.setAttribute("username", "ԓ�Ñ������]�ԣ�Ո����ݔ���µ��Ñ���");
			this.gotoPage("public/register.jsp",request,response);
		}else{
			//���]����Ϣ�����������У�������ӵ�ӛ�ӳ���User����
			user=ud.addUser(user);
			if(user.getUsertypes().equals("admin")){
				request.setAttribute("errorMsg", "����T�Ñ��]�Գɹ���Ո�M����T�����~̖");
//				�D�ص�����
				this.gotoPage("public/login.jsp", request, response);
			}
//			����]���Ñ��ǌW��
			if(user.getUsertypes().equals("student")){
//				���b�]�ԌW���Ñ���Ϣ���W��id����request��
				request.setAttribute("sid", user.getId());
//				�D��studentresume.jsp���
				this.gotoPage("stu/studentInfo.jsp", request, response);
			}
//			����]�Ե��Ñ�����I
			if(user.getUsertypes().equals("company")){
//				���b�]����I�Ñ���Ϣ����Iid����request��
				request.setAttribute("cid", user.getId());
				this.gotoPage("company/companyInfo.jsp", request, response);

			}
		}
		
	}
	*/
		//��ע����Ϣд�����ݿ��У�������ӵļ�¼ӳ��User����
		user=ud.addUser(user);
		if(user.getUsertypes().equals("admin")){
			request.setAttribute("errorMsg", "����T�Ñ��]�Գɹ���Ո�M����T�����~̖");
//			�D�ص�����
			this.gotoPage("public/login.jsp", request, response);
		}
//		����]���Ñ��ǌW��
		if(user.getUsertypes().equals("student")){
//			���b�]�ԌW���Ñ���Ϣ���W��id����request��
			request.setAttribute("sid", user.getId());
//			�D��studentresume.jsp���
			this.gotoPage("stu/studentInfo.jsp", request, response);
		}
//		����]�Ե��Ñ�����I
		if(user.getUsertypes().equals("company")){
//			���b�]����I�Ñ���Ϣ����Iid����request��
			request.setAttribute("cid", user.getId());
			this.gotoPage("company/companyInfo.jsp", request, response);

		}
	}
		

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	

}
