package cn.yjpt.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Message;
import cn.yjpt.bean.User;
import cn.yjpt.dao.MessageDao;
import cn.yjpt.dao.service.MessageDaoImpl;

/**
 * Servlet implementation class MessageManageServlet
 */
@WebServlet("/MessageManageServlet")
public class MessageManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageManageServlet() {
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
		// 获取请求参数action的值
		String action = request.getParameter("action");
		MessageDao md = new MessageDaoImpl();
		// 将留言板内容添加到数据库中
		if (action.equals("add")) {
			String username = request.getParameter("username");
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Date d = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			String time = df.format(d);
			Message message = new Message();
			// 用字符串变量title为Message对象msg的title的属性赋值
			message.setId(id);
			message.setUsername(username);
			message.setTitle(title);
			message.setContent(content);
			message.setMsgtime(time);
			boolean flag = md.addMessage(message);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("list")) {
			// 获取当前页
			String pageStr = request.getParameter("page");
			int pageNo = 0;
			if (pageStr == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.parseInt(pageStr);
			}
			DoPage dopage = new DoPage();
			dopage.setNowPage(pageNo);
			dopage.setPageSize(5);
			String sql = "";
			User user = (User) session.getAttribute("user");
			if (!user.getUsertypes().equals("admin")) {
				sql = "where id=" + user.getId();
			}
			dopage.setSql(sql);
			// 查询页面相关信息
			// 设置dopage2的totalPage和count属性值ֵ
			dopage.setCount(md.doCount(dopage));
			dopage.setTotalPage(md.doTotalPage(dopage));
			// dopage已经包含nowPage、pagesize、sql、count、totalPage5个参数值
			dopage = md.doFindAll(dopage);
			// 设置dopage为请求属性doPage的值
			request.setAttribute("doPage", dopage);
			// 转发请求到admin/listmessage.jsp页面
			this.gotoPage("public/messageList.jsp", request, response);
		}

		if (action.equals("reply")) {
			int mid = Integer.parseInt(request.getParameter("mid").trim());
			Message message = md.lookMessageById(mid);
			request.setAttribute("message", message);
			this.gotoPage("admin/reply.jsp", request, response);
		}
		if (action.equals("addreply")) {
			System.out.println("請求到了");
			int mid = Integer.parseInt(request.getParameter("mid"));
			Message message = new Message();
			message.setMid(mid);
			message.setReply(request.getParameter("reply"));
			Date date = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			String time = df.format(date);
			message.setReplytime(time);
			boolean flag = md.addReply(message);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("delete")) {
			System.out.println("請求到了");
			int mid = Integer.parseInt(request.getParameter("mid"));
			boolean flag = md.deleteMessage(mid);
			if (flag) {
				this.gotoPage("messageManage?action=list", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		} else {
			System.out.println("請求bu到了");
		}

	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
