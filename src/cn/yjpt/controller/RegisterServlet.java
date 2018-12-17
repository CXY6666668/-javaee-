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
//			错误提示
			request.setAttribute("username", username);
			request.setAttribute("usertypes", usertypes);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/error");
			dispatcher.forward(request, response);
		}*/
		
		
//		定義User對象，屬性值初始化為默認值
		User user=new User();
//		獲取用戶提供的輸入值
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
//		使用输入值设置对象user的属性值
		user.setUsername(username);;
		user.setPassword(password);
		user.setUsertypes(usertypes);
//		使用輸入值設置對象u的屬性值
//		创建UserDao对象
		UserDao ud=new UserDaoImpl();
		/*
//		檢測用戶名是否已經註冊
		boolean flag=ud.checkUsername(username);
		if(flag){
			request.setAttribute("username", "該用戶名已註冊，請重新輸入新的用戶名");
			this.gotoPage("public/register.jsp",request,response);
		}else{
			//把註冊信息寫到數據庫中，返回添加的記錄映射的User對象
			user=ud.addUser(user);
			if(user.getUsertypes().equals("admin")){
				request.setAttribute("errorMsg", "管理員用戶註冊成功，請聯繫管理員激活賬號");
//				轉回登錄頁面
				this.gotoPage("public/login.jsp", request, response);
			}
//			如果註冊用戶是學生
			if(user.getUsertypes().equals("student")){
//				封裝註冊學生用戶信息（學生id）到request中
				request.setAttribute("sid", user.getId());
//				轉到studentresume.jsp頁面
				this.gotoPage("stu/studentInfo.jsp", request, response);
			}
//			如果註冊的用戶是企業
			if(user.getUsertypes().equals("company")){
//				封裝註冊企業用戶信息（企業id）到request中
				request.setAttribute("cid", user.getId());
				this.gotoPage("company/companyInfo.jsp", request, response);

			}
		}
		
	}
	*/
		//把注册信息写到数据库中，返回添加的记录映射User对象
		user=ud.addUser(user);
		if(user.getUsertypes().equals("admin")){
			request.setAttribute("errorMsg", "管理員用戶註冊成功，請聯繫管理員激活賬號");
//			轉回登錄頁面
			this.gotoPage("public/login.jsp", request, response);
		}
//		如果註冊用戶是學生
		if(user.getUsertypes().equals("student")){
//			封裝註冊學生用戶信息（學生id）到request中
			request.setAttribute("sid", user.getId());
//			轉到studentresume.jsp頁面
			this.gotoPage("stu/studentInfo.jsp", request, response);
		}
//		如果註冊的用戶是企業
		if(user.getUsertypes().equals("company")){
//			封裝註冊企業用戶信息（企業id）到request中
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
