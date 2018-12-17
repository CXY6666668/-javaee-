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
import cn.yjpt.bean.Employment;
import cn.yjpt.bean.Message;
import cn.yjpt.dao.EmploymentDao;
import cn.yjpt.dao.service.EmploymentDaoImpl;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class EmploymentManageServlet
 */
@WebServlet("/EmploymentManageServlet")
public class EmploymentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmploymentManageServlet() {
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
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		EmploymentDao ed = new EmploymentDaoImpl();
		if (action.equals("add")) {
			String studentusername = request.getParameter("studentusername");
		//	int eid = Integer.parseInt(request.getParameter("eid"));
			String school = request.getParameter("school");
			String companyname = request.getParameter("companyname");
			String position = request.getParameter("position");
			Employment employment = new Employment();
		//	employment.setEid(eid);
			employment.setStudentusername(studentusername);
			employment.setCompanyname(companyname);
			employment.setPosition(position);
			employment.setSchool(school);
			System.out.println("发布就业:"+employment);
			boolean flag = ed.addEmployment(employment);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);
			}

		}
		if(action.equals("list")){
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
        		dopage.setSql(" where studentusername like '%" + sql + "%' ");
        	}
        	//获取总页数
        	int totalPage=ed.doTotalPage(dopage);
        	dopage.setTotalPage(totalPage);
        	//执行查询操作，参数是doPage
        	dopage = ed.doFindAll(dopage);			
        	// 将返回的结果，放到request中到jsp中显示
        	request.setAttribute("doPage", dopage);
        	// 页面跳转
        	this.gotoPage("public/employmentlist.jsp", request, response);
        }
        if(action.equals("edit")){
        	String eidStr=request.getParameter("eid");
        	int eid=0;
        	try {
				eid=Integer.parseInt(eidStr);
			} catch (NumberFormatException e) {				
				e.printStackTrace();
			}
        	Employment employment=ed.lookEmployment(eid);
        	request.setAttribute("employment", employment);
        	this.gotoPage("admin/editEmployment.jsp", request, response);
        }
        if(action.equals("update")){
        	Employment employment=new Employment();
        	int eid=0;
        	eid=Integer.parseInt(request.getParameter("eid"));
        	
        	employment.setEid(eid);
        	//employment.setEid(Integer.parseInt(request.getParameter("eid")));
        	employment.setStudentusername(request.getParameter("studentusername"));
        	employment.setSchool(request.getParameter("school"));
        	employment.setCompanyname(request.getParameter("companyname"));
        	employment.setPosition(request.getParameter("position"));
        	System.out.println(employment);
        	boolean flag=ed.updateEmployment(employment);
        	if(flag){
        		this.gotoPage("public/success.jsp", request, response);
        	}else{
        		this.gotoPage("public/error.jsp", request, response);
        	}
        }
        if(action.equals("delete")){
        	String eidStr=request.getParameter("eid");
        	int eid=0;
        	try {
				eid=Integer.parseInt(eidStr);
			} catch (NumberFormatException e) {				
				e.printStackTrace();
			}
        	boolean flag=ed.deleteEmployment(eid);
        	if(flag){
        		this.gotoPage("public/success.jsp", request, response);
        	}else{
        		this.gotoPage("public/error.jsp", request, response);
        	}
        }
	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
