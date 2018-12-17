package cn.yjpt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.Student;
import cn.yjpt.bean.User;
import cn.yjpt.dao.StudentDao;
import cn.yjpt.dao.service.StudentDaoImpl;

/**
 * Servlet implementation class StudentManageServlet
 */
@WebServlet("/StudentManageServlet")
public class StudentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentManageServlet() {
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
		StudentDao sd = new StudentDaoImpl();
		if (action.equals("sturegister")) {
			String id = request.getParameter("sid");
			int sid = 0;
			try {
				sid = Integer.parseInt(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String idnumber = request.getParameter("idnumber");
			String school = request.getParameter("school");
			String department = request.getParameter("department");
			String major = request.getParameter("major");
			String education = request.getParameter("education");
			String entrancedate = request.getParameter("entrancedate");
			String nativeplace = request.getParameter("nativeplace");
			Student student = new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setGender(gender);
			student.setIdnumber(idnumber);
			student.setSchool(school);
			student.setDepartment(department);
			student.setMajor(major);
			student.setEducation(education);
			student.setEntrancedate(entrancedate);
			student.setNativeplace(nativeplace);

			boolean flag = sd.addStudent(student);
			if (flag) {
				request.setAttribute("errorMsg", "学生用户注册成功，请联系管理员激活账号");
				this.gotoPage("public/login.jsp", request, response);
			} else {
				request.setAttribute("sid", student.getSid());
				this.gotoPage("stu/studentInfo.jsp", request, response);
			}
		}

		if (action.equals("show")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			int sid = 0;
			if ("student".equals(user.getUsertypes())) {
				sid = user.getId();
			} else {
				String sidStr = request.getParameter("sid");
				try {
					sid = Integer.parseInt(sidStr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Student student = sd.lookStudent(sid);
			request.setAttribute("student", student);
			this.gotoPage("stu/showStudent.jsp", request, response);
		}

		if (action.equals("studentlist")) {
			// 请求参数获取条件查询
			String sql = request.getParameter("sql");
			// 查询所有的数据
			List<Student> students = sd.doFindAll();
			request.setAttribute("list", students);
			// 请求转发到admin/studentList.jsp
			this.gotoPage("admin/studentList.jsp?sql=" + sql, request, response);
			System.out.println(students);
		}
/*
		if (action.equals("show")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			int sid = 0;
			if (user.getUsertypes().equals("student")) {
				sid = user.getId();
			}else {
				
			}
			Student student = sd.lookStudent(sid);
			request.setAttribute("student", student);
			this.gotoPage("stu/showStudent.jsp", request, response);
		}
*/
		if (action.equals("delete")) {
			String sidstr = request.getParameter("sid").trim();
			int sid = 0;
			try {
				sid = Integer.parseInt(sidstr);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// 删除
			boolean flag = sd.deleteStudent(sid);
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
