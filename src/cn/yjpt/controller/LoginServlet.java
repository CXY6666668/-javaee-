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
	 * 获取客户端提交的表单数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
//		得到session对象
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("usertypes", usertypes);
		response.setContentType("text/html;charset=utf-8");
		*/
		//PrintWriter out=response.getWriter();
//		out.println("<html><head>");
//		out.println("<title>登录处理</title>");
//		out.println("</head>");
//		out.println("<boby>");
//		if("admin".equals(usertype)) {
//			if(("12".equals(username))&&("123".equals(password))){
//				out.println("欢迎管理员"+username+"登录成功");
//			}else {
//				out.println("管理员"+username+"用户名或密码不正确");
//			}
//		}
//		if("company".equals(usertype)) {
//			if(("张三".equals(username))&&("1234".equals(password))) {
//				out.println("公司"+username+"登录成功");
//			}else {
//				out.println("公司"+username+"用户名或密码不正确");
//			}
//		}
//		if("student".equals(usertype)) {
//			if(("晓晓".equals(username))&&("111".equals(password))) {
//				out.println("欢迎学生"+username+"登录成功");
//			}else {
//				out.println("学生"+username+"用户名或密码不正确");
//			}
//		}
//		out.println("</boby>");
//		out.println("</html>");
//		out.flush();
//		out.close();
		/*
		 * 
		 * 
		 * 获取客户端提交的表单数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
//		得到session对象
		HttpSession session=request.getSession();
//		把用户名和用户类型封装到session中
		session.setAttribute("username", username);
		session.setAttribute("usertypes", usertypes);
//		验证用户名，密码，用户类型是否存在
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
		out.println("<title>登录处理</title>");
		out.println("</head>");
		out.println("<boby>");
		//获取当前HttpSession 对象
		HttpSession session=request.getSession();
//		提取用户提交的表单数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
	//	String verify = request.getParameter("verify");
//		根据提取的用户输入值，构造一个User对象
		User user=new User();
//		用提取的表单数据设置user对象的属性值
		user.setUsername(username);
		user.setPassword(password);
		user.setUsertypes(usertypes);
	//	user.setVerify(verify);
//		创建UserDao对象，用来查询用户数据库是否存在
		UserDao ud=new UserDaoImpl();
		User u=ud.lookUser(user);
//		System.out.print(u.getVerify());
		
//		如果用户在数据库中存在，那么对象u的usertypes属性不是error
		if(u.getUsertypes().equals("error")){
//			说明用户不在
			//out.println("用户名或密码不存在");
			//在请求对象中设置属性值
			request.setAttribute("errorMsg", "用户名或密码不存在");
//			转发回登录页面
			this.gotoPage("public/login.jsp",request,response);
		}else{//用户存在
			if(u.getVerify().equals("1")){
				//out.println("用户未激活，请联系管理员");
				request.setAttribute("errorMsg", "用户未激活，请联系管理员");
				this.gotoPage("public/loign.jsp", request, response);
			}
//			说明用户已通过审核
			if(u.getVerify().equals("2")){
				//把当前用户封装到session属性中
				session.setAttribute("user", u);
//				判断用户身份
				if(u.getUsertypes().equals("student")){
					//out.println("欢迎学生:"+user.getUsername()+"登录");
					this.gotoPage("stu/stuindex.jsp", request, response);
				}
				if(u.getUsertypes().equals("company")){
					//out.println("欢迎公司:"+user.getUsername()+"登录");
					this.gotoPage("company/companyindex.jsp", request, response);
				}
				if(u.getUsertypes().equals("admin")){
					//out.println("欢迎管理员:"+user.getUsername()+"登录");
					this.gotoPage("admin/index.jsp", request, response);
				}
			}
			if(u.getVerify().equals("3")){
				//out.println("用户审核未通过，请重新注册，如实填写信息");
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
