package cn.yjpt.dao;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.User;

public interface UserDao {
	//��ѯ�û��Ƿ�������ݿ�
	  //���巽����ѯ�û���¼��Ϣ�Ƿ����
    User lookUser(User user);
//����û����Ƿ����
	boolean checkUsername(String username);
//���û�ע����Ϣ��ӵ����ݿ���
	User addUser(User user);
//	���巽�����޸��û�����
	boolean updatePwd(User user);
//	���巽����ȡ�ܼ�¼��
	int doCount(DoPage dopage);
//	���巽������ȡ��ҳ��
	int doTatalPage(DoPage dopage);
//	���巽����ѯĳһҳҪ��ʾ������
	DoPage doFindAll(DoPage dopage);
// ɾ���û�
	boolean deleteUser(int id);
//	�����û�
	boolean disableUser(int id);
//	�����û�
	boolean activeUser(int id);
//	�����û����δͨ��
	boolean invalid(int id);
//	����id��ѯ
	User lookUserById(int id);

   
}