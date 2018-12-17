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
import cn.yjpt.bean.Recurit;
import cn.yjpt.dao.RecuritDao;
import cn.yjpt.dao.service.RecuritDaoImpl;

/**
 * Servlet implementation class RecruitManageServlet
 */
@WebServlet("/RecruitManageServlet")
public class RecruitManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecruitManageServlet() {
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
		String action = request.getParameter("action");
		RecuritDao rd = new RecuritDaoImpl();
		if (action.equals("recruitlist")) {
			DoPage dopage = new DoPage();
			String pageNum = request.getParameter("page");
			int pageNo = 0;
			if (pageNum == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.parseInt(pageNum);
			}
			dopage.setNowPage(pageNo);
			dopage.setPageSize(10);
			String sql = request.getParameter("sql");
			if (sql == null) {
				sql = "";
				dopage.setSql(sql);
			} else if (sql.endsWith("%")) {
				dopage.setSql(sql);
			} else {
				dopage.setSql(" where companyname like '%" + sql + "%' ");
			}
			// 获取总页数
			int totalPage = rd.doTotalPage(dopage);
			dopage.setTotalPage(totalPage);
			// 执行查询操作，参数是doPage
			dopage = rd.doFindAll(dopage);
			// 将返回的结果，放到request中到jsp中显示
			request.setAttribute("doPage", dopage);
			// 页面跳转
			this.gotoPage("admin/recuritlist.jsp", request, response);
		}
		if (action.equals("show")) {
			String ridStr = request.getParameter("rid");
			int rid = 0;
			try {
				rid = Integer.parseInt(ridStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			Recurit recurit = rd.lookRecurit(rid);
			request.setAttribute("recurit", recurit);
			System.out.println("recurit" + recurit);
			this.gotoPage("public/showRecurit.jsp", request, response);

		}

		if (action.equals("add")) {
			// 把Recurit。jsp页面填写的内容写入数据库
			Recurit recurit = new Recurit();
			String cidstr = request.getParameter("cid");
			int cid = 0;
			try {
				cid = Integer.parseInt(cidstr);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			recurit.setCid(cid);
			recurit.setCompanyname(request.getParameter("companyname"));
			recurit.setAddress(request.getParameter("address"));
			recurit.setPostcode(request.getParameter("postcode"));
			recurit.setRecruitment(request.getParameter("recruitment"));
			// recurit.setRecruitment(request.getParameter("recruitment"));
			int recruitment = 0;
			recurit.setWorkingplace(request.getParameter("workingplace"));
			recurit.setPositiontype(request.getParameter("positiontype"));
			recurit.setEdurequire(request.getParameter("edurequire"));
			recurit.setDescription(request.getParameter("description"));
			recurit.setBranch(request.getParameter("branch"));
			recurit.setLinkman(request.getParameter("linkman"));
			recurit.setTelephone(request.getParameter("telephone"));
			recurit.setHostpage(request.getParameter("hostpage"));
			System.out.print(recurit.getHostpage());
			recurit.setEmail(request.getParameter("email"));
			RecuritDao ed = new RecuritDaoImpl();
			boolean flag = ed.addRecurit(recurit);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);

			}
		}

		if (action.equals("edit")) {
			Recurit recurit = new Recurit();
			String ridStr = request.getParameter("rid");
			int rid = 0;
			try {
				rid = Integer.parseInt(ridStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			recurit = rd.lookRecurit(rid);

			request.setAttribute("recurit", recurit);
			this.gotoPage("public/updaterecurit.jsp", request, response);
		}

		if (action.equals("update")) {
			System.out.println("進入修改");
			Recurit recurit = new Recurit();
			String ridStr = request.getParameter("rid");
			// 1,'1',"2"=2,"3"=3,"rid"=,"1as2233"
			int rid = 0;
			try {
				rid = Integer.parseInt(ridStr);
				// rid = Integer.parseInt("abckk"); //需要前参数值才能转，“1”，“abc”错误
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			recurit.setRid(rid);
			// recurit.setCid(cid);
			recurit.setCompanyname(request.getParameter("companyname"));
			recurit.setAddress(request.getParameter("address"));
			recurit.setPostcode(request.getParameter("positiontype"));
			recurit.setRecruitment(request.getParameter("recruitment"));
			// recurit.setRecruitment(request.getParameter("recruitment"));
			int recruitment = 0;
			recurit.setWorkingplace(request.getParameter("workingplace"));
			recurit.setPositiontype(request.getParameter("positiontype"));
			recurit.setEdurequire(request.getParameter("edurequire"));
			recurit.setDescription(request.getParameter("description"));
			recurit.setBranch(request.getParameter("branch"));
			recurit.setLinkman(request.getParameter("linkman"));
			recurit.setTelephone(request.getParameter("telephone"));
			recurit.setHostpage(request.getParameter("hostpage")); //
			System.out.print(recurit.getHostpage());
			recurit.setEmail(request.getParameter("email"));
			boolean flag = rd.updateRecurit(recurit);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}

		}

		if (action.equals("delete")) {
			String ridStr = request.getParameter("rid");
			int rid = 0;
			try {
				rid = Integer.parseInt(ridStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			boolean flag = rd.deleteRecurit(rid);
			if (flag) {
				this.gotoPage("recruitManage?action=recruitlist", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
