package cn.yjpt.dao;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Resume;

public interface ResumeDao {
	public boolean addResume(Resume resume);

	public Resume lookResume(int sid);

	public boolean updateResume(Resume resume);

	public boolean deleteResume(int sid);

	// ���巽����ȡ�ܼ�¼��
	public int doCount(DoPage dopage);

	// ���巽����ȡ��ҳ��
	public int doTotalPage(DoPage dopage);

	// ��ѯĳһҳ���е�����
	public DoPage doFindAll(DoPage dopage);
}
