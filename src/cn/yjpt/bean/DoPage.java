package cn.yjpt.bean;

import java.util.List;

public class DoPage {
//	����nowPage��ʾ��ǰ�ǵڼ�ҳ
	private int nowPage;
//	����pageSize��ʾÿҳ���ж�������¼
	private int pageSize;
//	����totalPage��ʾ�ܹ��ж���ҳ
	private int totalPage;
//	����List�б����list������װĳһҳҪ��ʾ�����м�¼
	private List list;
//	����һ��SQL��ʾ��ѯ����
	private String sql;
//	����count��ʾ�ܹ��ж�������¼
	private int count;
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
