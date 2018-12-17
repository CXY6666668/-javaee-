package cn.yjpt.dao;

import cn.yjpt.bean.Resume;

public interface ResumeDao {
	public boolean addResume(Resume resume);

	public Resume lookResume(int sid);

}
