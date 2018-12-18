package cn.yjpt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.User;
import cn.yjpt.dao.UserDao;
import cn.yjpt.dao.service.UserDaoImpl;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManageServlet() {
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
		// 提取隐藏控件action的值，判断提交文件时哪个表单
		String action = request.getParameter("action");
		UserDao ud = new UserDaoImpl();
		if (action.equals("update")) {
			User user = new User();
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			user.setId(id);
			user.setPassword(request.getParameter("password"));
			// System.out.println(user.getId());
			// 把已经更新的密码属性作为新值对象写到数据中

			boolean flag = ud.updatePwd(user);
			if (flag) {
				// 从Httpsession中取出封装的user的值，即当前登录用户
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("user");
				System.out.println(loginUser.getUsername() + loginUser.getUsertypes());
				// System.out.println(loginUser.getPassword() +
				// loginUser.getId());

				// 如果是管理员修改密码
				if (loginUser.getUsertypes().equals("admin")) {
					this.gotoPage("userManage?action=list", request, response);
				} else {
					this.gotoPage("public/success.jsp", request, response);
				}
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("list")) {
			// 创建DoPage对象
			DoPage dopage = new DoPage();
			// 获取当前是第几页参数
			String pageNum = request.getParameter("page");// 从请求参数获取当前的第几页
			int pageNo = 0;
			if (pageNum == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.parseInt(pageNum);
			}
			// 设置dopage对象的当前页属性
			dopage.setNowPage(pageNo);
			// 从请求参数获取条件查询
			String sqlStr = request.getParameter("sql");
			if (sqlStr == null) {
				sqlStr = "";
			} else if (sqlStr.equals("1")) {
				sqlStr = " where verify='1'";
			} else if (sqlStr.equals("2")) {
				sqlStr = " where verify='2'";
			} else if (sqlStr.equals("3")) {
				sqlStr = " where verify='3'";
			} else {
				sqlStr = "";
			}
			// 用获取到的条件查询参数值设置dopae1对象属性sql的值
			dopage.setSql(sqlStr);
			// 用常量10设置dopage的属性值pageSize属性值
			dopage.setPageSize(10);
			// 取总记录数,设置为dopage的count属性值
			int totalcount = ud.doCount(dopage);
			dopage.setCount(totalcount);
			// 取总页数，设置为dopage的totalPage属性值
			int totalpage = ud.doTatalPage(dopage);
			dopage.setTotalPage(totalpage);
			// 调用Dao类方法获取当前页要显示的记录，并且把记录集合封装为dopage对象list属性值
			dopage = ud.doFindAll(dopage);// 返回对象中参数都有值
			// 把dopage设置为请求属性doPage的属性值
			request.setAttribute("doPage", dopage);
			// 请求转发到admin/listuser.jsp页面
			this.gotoPage("admin/userList.jsp", request, response);
		}
		if (action.equals("disable")) {
			// 使用户不能登录
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			ud.disableUser(id);
			this.gotoPage("userManage?action=list", request, response);
		}
		if (action.equals("invalid")) {
			// 使用户不能通过审核
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			ud.invalid(id);
			this.gotoPage("userManage?action=list", request, response);
		}
		if (action.equals("active")) {
			// 使用户可以登录
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			ud.activeUser(id);
			this.gotoPage("userManage?action=list", request, response);

		}
		if (action.equals("update")) {
			User user = new User();
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			user.setId(id);
			user.setPassword(request.getParameter("password"));
			boolean flag = ud.updatePwd(user);
			if (flag) {
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("user");
				System.out.println(loginUser.getUsername() + loginUser.getUsertypes());
				// 如果是管理员修改用户密码
				if (loginUser.getUsertypes().equals("admin")) {
					this.gotoPage("userManage?action=list", request, response);
				} else {
					this.gotoPage("public/success.jsp", request, response);
				}
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("delete")) {
			User user = new User();
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			ud.deleteUser(id);
			this.gotoPage("userManage?action=list", request, response);
		}

	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
