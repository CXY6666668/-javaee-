package cn.yjpt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.Recurit;
import cn.yjpt.bean.Resume;
import cn.yjpt.bean.User;
import cn.yjpt.bean.recuritresume;
import cn.yjpt.dao.RecuritDao;
import cn.yjpt.dao.RecuritResumeDao;
import cn.yjpt.dao.ResumeDao;
import cn.yjpt.dao.service.RecuritDaoImpl;
import cn.yjpt.dao.service.RecuritResumeImpl;
import cn.yjpt.dao.service.ResumeDaoImpl;

/**
 * Servlet implementation class recruitresumeServlet
 */
@WebServlet("/recruitresumeServlet")
public class recruitresumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public recruitresumeServlet() {
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
		RecuritResumeDao rrs = new RecuritResumeImpl();
		String action = request.getParameter("action");
		if (action.equals("tou")) {
			int rid = 0, cid = 0, sid = 0;
			String ridStr = request.getParameter("rid");
			System.out.println("ridStr是多少" + ridStr);
			try {
				rid = Integer.parseInt(ridStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			String cidStr = request.getParameter("cid");
			System.out.println("cidStr是多少" + cidStr);
			try {
				cid = Integer.parseInt(cidStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			String sidStr = request.getParameter("sid");
			System.out.println("sidStr是多少" + sidStr);
			try {
				sid = Integer.parseInt(sidStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			recuritresume rr = new recuritresume();
			rr.setRid(rid);
			rr.setCid(cid);
			rr.setSid(sid);
			boolean flag = rrs.addRecuritResume(rr);
			System.out.println("所有的id：" + rr);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("list")) {
			User user = (User) session.getAttribute("user");
			int cid = user.getId();
			System.out.println("输出：" + cid);
			// [1,2,3];3
			// [{1,21,2},{1,21,2},{1}];3
			// json
			List<Integer> cidList = rrs.lookRecuritsByCid(cid);
			List<Recurit> recuritlist = new ArrayList<Recurit>();
			RecuritDao rd = new RecuritDaoImpl();
			System.out.println(cidList);
			/*
			 * for (int i = 0; i < cidList.size(); i++) { cidList.get(i); }
			 */
			for (Integer id : cidList) {
				Recurit recruit = rd.lookRecurit(id);
				recuritlist.add(recruit);

				// System.out.println("qingshuchu:" + recruit);
			}
			request.setAttribute("recuritlist", recuritlist);
			// System.out.println("qing" + recuritlist);
			this.gotoPage("company/getrecurit.jsp", request, response);
		}
		if (action.equals("showresumes")) {
			String ridStr = request.getParameter("rid");
			int rid = 0;
			try {
				rid = Integer.parseInt(ridStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			List<Integer> sidlist = rrs.lookResumesByRid(rid);
			ResumeDao rd = new ResumeDaoImpl();
			List<Resume> resumelist = new ArrayList<Resume>();
			for (Integer zdy : sidlist) {
				Resume resume = rd.lookResume(zdy);
				resumelist.add(resume);
			}
			request.setAttribute("resumelist", resumelist);
			this.gotoPage("company/getresume.jsp", request, response);
		}

	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
