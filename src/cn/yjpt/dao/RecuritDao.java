package cn.yjpt.dao;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Recurit;

public interface RecuritDao {
	boolean addRecurit(Recurit recurit);

	// ���巽���޸���Ƹ��Ϣ
	public boolean updateRecurit(Recurit recurit);

	// ���巽��ɾ����Ƹ��Ϣ
	public boolean deleteRecurit(int rid);

	// ���巽����ѯ��Ƹ��Ϣ
	public Recurit lookRecurit(int rid);

	// ���巽����ѯ�ܼ�¼��
	public int doCount(DoPage dopage);

	// ���巽����ѯ��ҳ��
	public int doTotalPage(DoPage dopage);

	// ���巽����ѯĳһҳ����ʾ�ļ�¼
	public DoPage doFindAll(DoPage dopage);
}
