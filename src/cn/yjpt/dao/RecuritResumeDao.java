package cn.yjpt.dao;

import java.util.List;

import cn.yjpt.bean.recuritresume;

public interface RecuritResumeDao {
	// ���巽��ѧ��Ͷ�ݼ���
	boolean addRecuritResume(recuritresume recuritresume);

	// ���巽��������Ƹid��ѯ����Ͷ�ݵļ���id����
	List<Integer> lookResumesByRid(int sid);

	// ���巽����ѯĳ����˾�յ�ѧ����������Ƹ��Ϣid����
	List<Integer> lookRecuritsByCid(int cid);

}
