package cn.yjpt.bean;

public class Employment {
	private int eid;
	private String studentusername;
	private String school;
	private String companyname;
	private String position;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getStudentusername() {
		return studentusername;
	}
	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Employment [eid=" + eid + ", studentusername=" + studentusername + ", school=" + school
				+ ", companyname=" + companyname + ", position=" + position + "]";
	}
	
}
