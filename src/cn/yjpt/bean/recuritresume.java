package cn.yjpt.bean;

public class recuritresume {
	private int rid;// ��Ƹ��Ϣ
	private int cid;// ��Ƹ��λ
	private int sid;// ѧ������

	@Override
	public String toString() {
		return "recuritresume [rid=" + rid + ", cid=" + cid + ", sid=" + sid + "]";
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

}
