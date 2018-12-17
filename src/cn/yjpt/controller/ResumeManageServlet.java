package cn.yjpt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yjpt.bean.Resume;
import cn.yjpt.bean.Student;
import cn.yjpt.bean.User;
import cn.yjpt.dao.ResumeDao;
import cn.yjpt.dao.StudentDao;
import cn.yjpt.dao.service.ResumeDaoImpl;
import cn.yjpt.dao.service.StudentDaoImpl;

/**
 * Servlet implementation class ResumeManageServlet
 */
@WebServlet("/ResumeManageServlet")
public class ResumeManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResumeManageServlet() {
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
		ResumeDao rd = new ResumeDaoImpl();

		if (action.equals("create")) {
			User user = (User) session.getAttribute("user");
			StudentDao sd = new StudentDaoImpl();
			Student student = sd.lookStudent(user.getId());
			request.setAttribute("student", student);
			this.gotoPage("stu/resumeManage.jsp", request, response);
		}
		if (action.equals("add")) {
			Resume resume = new Resume();
			// 获取前端参数
			int sid = Integer.parseInt(request.getParameter("sid").trim());
			System.out.println(sid);
			String sname = request.getParameter("sname");
			// System.out.println("sname"+sname);
			String gender = request.getParameter("gender");
			String birthdate = request.getParameter("birthdate");
			String nation = request.getParameter("nation");
			String education = request.getParameter("education");
			System.out.println("education" + education);

			String politics = request.getParameter("politics");
			String graduation = request.getParameter("graduation");
			System.out.println("graduation" + graduation);
			String school = request.getParameter("school");
			String major = request.getParameter("major");
			String email = request.getParameter("email");
			String foreignlanguage = request.getParameter("foreignlanguage");
			String hobby = request.getParameter("hobby");
			String honor = request.getParameter("honor");
			String phone = request.getParameter("phone");
			String position = request.getParameter("position");
			String practice = request.getParameter("practice");
			String research = request.getParameter("research");
			String selfevaluation = request.getParameter("selfevaluation");
			resume.setSid(sid);
			resume.setSname(sname);
			resume.setBirthdate(birthdate);
			resume.setEducation(education);
			resume.setEmail(email);
			resume.setForeignlanguage(foreignlanguage);
			resume.setGender(gender);
			resume.setGraduation(graduation);
			resume.setHobby(hobby);
			resume.setMajor(major);
			resume.setNation(nation);
			resume.setPhone(phone);
			resume.setPolitics(politics);
			resume.setPosition(position);
			resume.setResearch(research);
			resume.setHonor(honor);
			resume.setPractice(practice);
			resume.setSchool(school);
			resume.setSelfevaluation(selfevaluation);
			System.out.println("这里输出：" + resume.getGraduation());
			boolean flag = rd.addResume(resume);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			} else {
				this.gotoPage("public/error.jsp", request, response);

			}

		}
		if (action.equals("edit")) {

		}

	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
