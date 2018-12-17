package cn.yjpt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.Company;
import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Student;
import cn.yjpt.bean.User;
import cn.yjpt.dao.CompanyDao;
import cn.yjpt.dao.service.CompanyDaoImpl;

/**
 * Servlet implementation class CompanyManageServlet
 */

public class CompanyManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyManageServlet() {
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
		String action = request.getParameter("action");

		CompanyDao cd = new CompanyDaoImpl();
		if (action.equals("companyregister")) {
			Company company = new Company();
			String id = request.getParameter("cid");
			int cid = 0;
			try {
				cid = Integer.parseInt(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			String companyname = request.getParameter("companyname");
			String unitproperty = request.getParameter("unitproperty");
			String industry = request.getParameter("industry");
			String licensenumber = request.getParameter("licensenumber");
			String unitscale = request.getParameter("unitscale");
			String address = request.getParameter("address");
			String webaddress = request.getParameter("webaddress");
			String linkman = request.getParameter("linkman");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			String postcode = request.getParameter("postcode");

			company.setCid(cid);
			company.setCompanyname(companyname);
			company.setUnitproperty(unitproperty);
			company.setEmail(email);
			company.setIndustry(industry);
			company.setLicensenumber(licensenumber);
			company.setLinkman(linkman);
			company.setUnitproperty(unitproperty);
			company.setAddress(address);
			company.setWebaddress(webaddress);
			company.setTelephone(telephone);
			company.setPostcode(postcode);
			company.setUnitscale(unitscale);
			System.out.println(industry);
			System.out.println(unitscale);
			boolean flag = cd.addCompany(company);
			System.out.println(flag);
			if (flag) {
				request.setAttribute("errorMsg", "企业用户注册成功，请联系管理员激活账号");
				this.gotoPage("public/login.jsp", request, response);

			} else {
				request.setAttribute("cid", company.getCid());
				this.gotoPage("company/companyInfo.jsp", request, response);

			}
		}
		if (action.equals("edit")) {

			HttpSession session = request.getSession();
			Company company = new Company();
			User user = (User) session.getAttribute("user");
			if (user.getUsertypes().equals("company")) {
				company = cd.lookCompany(user.getId());
			} else if (user.getUsertypes().equals("admin")) {
				String cidStr = request.getParameter("cid");
				int cid = 0;
				cid = Integer.parseInt(cidStr);

				company = cd.lookCompany(cid);
			}
			request.setAttribute("company", company);
			this.gotoPage("company/companyedit.jsp", request, response);
		}
		if (action.equals("choose")) {
			Company company = new Company();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user.getUsertypes().equals("company")) {
				company = cd.lookCompany(user.getId());
			} else if (user.getUsertypes().equals("admin")) {
				String cidStr = request.getParameter("cid");
				int cid = 0;
				try {
					cid = Integer.parseInt(cidStr);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				company = cd.lookCompany(cid);
			}
			request.setAttribute("company", company);
			this.gotoPage("public/Recurit.jsp", request, response);
		}
		// 管理员查看所有企业信息
		if (action.equals("companylist")) {
			// 封装分页查询的参数的对象doPage
			DoPage dopage = new DoPage();
			//获取当前是第几页参数
			String pageNum=request.getParameter("page");
			int pageNo=0;
			if(pageNum==null){
				pageNo=1;
			}else{
				pageNo=Integer.parseInt(pageNum);
		    }
		    //设置dopage对象的当前页属性
		    dopage.setNowPage(pageNo);
			dopage.setPageSize(10);			
			String sql=request.getParameter("sql");
			if(sql==null){
				sql="";
				dopage.setSql(sql);
			}else if (sql.endsWith("%")) {
				dopage.setSql(sql);
		    } else {
				dopage.setSql(" where companyname like '%" + sql + "%' ");
			}
			//获取总页数
			int totalPage=cd.doTotalPage(dopage);
			dopage.setTotalPage(totalPage);
			//执行查询操作，参数是doPage
			dopage = cd.doFindAll(dopage);			
			// 将返回的结果，放到request中到jsp中显示
			request.setAttribute("doPage", dopage);
			// 页面跳转
			this.gotoPage("admin/companylist.jsp", request, response);
		}
		

		if (action.equals("show")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			int cid = 0;
			if ("company".equals(user.getUsertypes())) {
				cid = user.getId();
			} else {
				String cidCtr = request.getParameter("cid");
				try {
					cid = Integer.parseInt(cidCtr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Company company = cd.lookCompany(cid);
			request.setAttribute("company", company);
			this.gotoPage("company/showCompany.jsp", request, response);
		}

	
		if (action.equals("update")) {
			Company company = new Company();
			String cidStr = request.getParameter("cid");
			int cid = 0;
			try {
				cid = Integer.parseInt(cidStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			company.setCid(cid);
			company.setAddress(request.getParameter("address"));
			company.setCompanyname(request.getParameter("companyname"));
			company.setEmail(request.getParameter("email"));
			company.setIndustry(request.getParameter("industry"));
			company.setLicensenumber(request.getParameter("licensenumber"));
			company.setLinkman(request.getParameter("linkman"));
			company.setPostcode(request.getParameter("postcode"));
			company.setTelephone(request.getParameter("telephone"));
			company.setUnitproperty(request.getParameter("unitproperty"));
			company.setUnitscale(request.getParameter("unitscale"));
			company.setWebaddress(request.getParameter("webaddress"));
			boolean flag = cd.update(company);
			if (flag) {
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
