package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yjpt.bean.Resume;
import cn.yjpt.dao.ResumeDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class ResumeDaoImpl implements ResumeDao {

	Connection connection = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	@Override
	public boolean addResume(Resume resume) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		// String sql="insert into resume
		// values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql = "insert into resume (sid,sname,gender,birthdate,nation,politics,graduation,school,major,education,email,phone,foreignlanguage,hobby,practice,position,honor,research,selfevaluation ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			pstat = connection.prepareStatement(sql);
			pstat.setInt(1, resume.getSid());
			System.out.println("resume:" + resume);
			pstat.setString(2, resume.getSname());
			pstat.setString(3, resume.getGender());
			pstat.setString(4, resume.getBirthdate());
			pstat.setString(5, resume.getNation());
			pstat.setString(6, resume.getPolitics());
			pstat.setString(7, resume.getGraduation());
			pstat.setString(8, resume.getSchool());
			pstat.setString(9, resume.getMajor());
			pstat.setString(10, resume.getEducation());
			pstat.setString(11, resume.getEmail());
			pstat.setString(12, resume.getPhone());
			pstat.setString(13, resume.getForeignlanguage());
			pstat.setString(14, resume.getHobby());
			pstat.setString(15, resume.getPractice());
			pstat.setString(16, resume.getPosition());
			pstat.setString(17, resume.getHonor());
			pstat.setString(18, resume.getResearch());
			pstat.setString(19, resume.getSelfevaluation());
			int i = pstat.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);

		}
		return flag;
	}

	@Override
	public Resume lookResume(int sid) {
		// TODO Auto-generated method stub
		Resume resume = new Resume();
		// 1.连接数据库
		connection = ConnectionFactory.getConnection();
		String sql = "select * from resume where sid=" + sid;
		try {
			// 2.创建PreparedStatement对象
			pstat = connection.prepareStatement(sql);
			// 3.执行查询
			rs = pstat.executeQuery();
			// 4.处理结果
			if (rs.next()) {
				resume.setSid(rs.getInt("sid"));
				resume.setSname(rs.getString("sname"));
				resume.setGender(rs.getString("gender"));
				resume.setBirthdate(rs.getString("birthdate"));
				resume.setNation(rs.getString("nation"));
				resume.setPolitics(rs.getString("politics"));
				resume.setGraduation(rs.getString("graduation"));
				resume.setSchool(rs.getString("school"));
				resume.setMajor(rs.getString("major"));
				resume.setEducation(rs.getString("education"));
				resume.setEmail(rs.getString("email"));
				resume.setPhone(rs.getString("phone"));
				resume.setForeignlanguage(rs.getString("foreignlanguage"));
				resume.setHobby(rs.getString("hobby"));
				resume.setPractice(rs.getString("practice"));
				resume.setPosition(rs.getString("position"));
				resume.setHonor(rs.getString("honor"));
				resume.setResearch(rs.getString("research"));
				resume.setSelfevaluation(rs.getString("selfevaluation"));
			} else {// 如果查询不到记录，设置学生sid的值为0
				resume.setSid(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		// 5.返回结果
		return resume;
	}

}
