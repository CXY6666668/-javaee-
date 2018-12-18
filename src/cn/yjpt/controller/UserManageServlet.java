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
		// ��ȡ���ؿؼ�action��ֵ���ж��ύ�ļ�ʱ�ĸ���
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
			// ���Ѿ����µ�����������Ϊ��ֵ����д��������

			boolean flag = ud.updatePwd(user);
			if (flag) {
				// ��Httpsession��ȡ����װ��user��ֵ������ǰ��¼�û�
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("user");
				System.out.println(loginUser.getUsername() + loginUser.getUsertypes());
				// System.out.println(loginUser.getPassword() +
				// loginUser.getId());

				// ����ǹ���Ա�޸�����
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
			// ����DoPage����
			DoPage dopage = new DoPage();
			// ��ȡ��ǰ�ǵڼ�ҳ����
			String pageNum = request.getParameter("page");// �����������ȡ��ǰ�ĵڼ�ҳ
			int pageNo = 0;
			if (pageNum == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.parseInt(pageNum);
			}
			// ����dopage����ĵ�ǰҳ����
			dopage.setNowPage(pageNo);
			// �����������ȡ������ѯ
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
			// �û�ȡ����������ѯ����ֵ����dopae1��������sql��ֵ
			dopage.setSql(sqlStr);
			// �ó���10����dopage������ֵpageSize����ֵ
			dopage.setPageSize(10);
			// ȡ�ܼ�¼��,����Ϊdopage��count����ֵ
			int totalcount = ud.doCount(dopage);
			dopage.setCount(totalcount);
			// ȡ��ҳ��������Ϊdopage��totalPage����ֵ
			int totalpage = ud.doTatalPage(dopage);
			dopage.setTotalPage(totalpage);
			// ����Dao�෽����ȡ��ǰҳҪ��ʾ�ļ�¼�����ҰѼ�¼���Ϸ�װΪdopage����list����ֵ
			dopage = ud.doFindAll(dopage);// ���ض����в�������ֵ
			// ��dopage����Ϊ��������doPage������ֵ
			request.setAttribute("doPage", dopage);
			// ����ת����admin/listuser.jspҳ��
			this.gotoPage("admin/userList.jsp", request, response);
		}
		if (action.equals("disable")) {
			// ʹ�û����ܵ�¼
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
			// ʹ�û�����ͨ�����
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
			// ʹ�û����Ե�¼
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
				// ����ǹ���Ա�޸��û�����
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
