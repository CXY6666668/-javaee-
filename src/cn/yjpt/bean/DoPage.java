package cn.yjpt.bean;

import java.util.List;

public class DoPage {
//	定义nowPage表示当前是第几页
	private int nowPage;
//	定义pageSize表示每页共有多少条记录
	private int pageSize;
//	定义totalPage表示总共有多少页
	private int totalPage;
//	定义List列表对象list用来封装某一页要显示的所有记录
	private List list;
//	定义一个SQL表示查询条件
	private String sql;
//	定义count表示总共有多少条记录
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
