package com.yushi.entity;

public class qianadmin {
	private Integer qid;
	private String qsno;
	private String qname;
	private String qdlpass;
	private String qsex;
	private String qage;
	private String qidc;
	private String goongzhi;
	public qianadmin() {
		super();
	}
	
	public qianadmin(Integer qid, String qsno, String qname, String qdlpass) {
		super();
		this.qid = qid;
		this.qsno = qsno;
		this.qname = qname;
		this.qdlpass = qdlpass;
	}

	public qianadmin(Integer qid, String qsno, String qname, String qdlpass, String qsex, String qage, String qidc,
			String goongzhi) {
		super();
		this.qid = qid;
		this.qsno = qsno;
		this.qname = qname;
		this.qdlpass = qdlpass;
		this.qsex = qsex;
		this.qage = qage;
		this.qidc = qidc;
		this.goongzhi = goongzhi;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getQsno() {
		return qsno;
	}
	public void setQsno(String qsno) {
		this.qsno = qsno;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getQdlpass() {
		return qdlpass;
	}
	public void setQdlpass(String qdlpass) {
		this.qdlpass = qdlpass;
	}
	public String getQsex() {
		return qsex;
	}
	public void setQsex(String qsex) {
		this.qsex = qsex;
	}
	public String getQage() {
		return qage;
	}
	public void setQage(String qage) {
		this.qage = qage;
	}
	public String getQidc() {
		return qidc;
	}
	public void setQidc(String qidc) {
		this.qidc = qidc;
	}
	public String getGoongzhi() {
		return goongzhi;
	}
	public void setGoongzhi(String goongzhi) {
		this.goongzhi = goongzhi;
	}
	@Override
	public String toString() {
		return "qianadmin [qid=" + qid + ", qsno=" + qsno + ", qname=" + qname + ", qdlpass=" + qdlpass + ", qsex="
				+ qsex + ", qage=" + qage + ", qidc=" + qidc + ", goongzhi=" + goongzhi + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
