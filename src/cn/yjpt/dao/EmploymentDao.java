package cn.yjpt.dao;


import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Employment;

public interface EmploymentDao {
	boolean addEmployment(Employment employment);

	//���巽���޸���ҵ������Ϣ 
		boolean updateEmployment(Employment employment);
		//���巽����ѯ��ҵ������Ϣ
		Employment lookEmployment(int eid);
		//���巽��ɾ����ҵ������Ϣ
		boolean deleteEmployment(int eid); 
		//���巽����ȡ��ҵ�����ܼ�¼��
		int doCount(DoPage dopage);
		//���巽����ȡ��ҳ��
		int doTotalPage(DoPage dopage);
		//���巽����ѯĳһҳҪ��ʾ������
		DoPage doFindAll(DoPage dopage);

}
