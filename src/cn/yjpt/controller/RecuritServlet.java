package cn.yjpt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.recompile;

import cn.yjpt.bean.Recurit;
import cn.yjpt.dao.RecuritDao;
import cn.yjpt.dao.service.RecuritDaoImpl;

/**
 * Servlet implementation class RecuritServlet
 */
@WebServlet("/RecuritServlet")
public class RecuritServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecuritServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String action = request.getParameter("action");
		RecuritDao rd=new RecuritDaoImpl();
		if (action.equals("publish")) {
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
			int recruitment=0;
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
			boolean flag=rd.addRecurit(recurit);
			if(flag) {
				this.gotoPage("public/success.jsp", request, response);
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
