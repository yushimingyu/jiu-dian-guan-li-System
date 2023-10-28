package com.yushi.entity;

public class Jingli {
	private Integer adminid;
	private String adminsno;
	private String adminpass;
	private String jlname;
	public Jingli() {
		super();
	}
	public Jingli(Integer adminid, String adminsno, String adminpass, String jlname) {
		super();
		this.adminid = adminid;
		this.adminsno = adminsno;
		this.adminpass = adminpass;
		this.jlname = jlname;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getAdminsno() {
		return adminsno;
	}
	public void setAdminsno(String adminsno) {
		this.adminsno = adminsno;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	public String getJlname() {
		return jlname;
	}
	public void setJlname(String jlname) {
		this.jlname = jlname;
	}
	@Override
	public String toString() {
		return "Jingli [adminid=" + adminid + ", adminsno=" + adminsno + ", adminpass=" + adminpass + ", jlname="
				+ jlname + "]";
	}
	
}
