package cn.yjpt.dao;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Message;

public interface MessageDao {
	boolean addMessage(Message message);

	Message lookMessageById(int mid);

	boolean addReply(Message message);

	int doCount(DoPage dopage);

	int doTotalPage(DoPage dopage);

	DoPage doFindAll(DoPage dopage);

	boolean deleteMessage(int mid);

}
