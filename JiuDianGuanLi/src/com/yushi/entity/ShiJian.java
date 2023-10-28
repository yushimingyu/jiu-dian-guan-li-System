package com.yushi.entity;

public class ShiJian {
	private Integer sid;
	private String shijan;
	private String yaoqiu;
	private String beizhu;
	private Integer sfno;
	public ShiJian() {
		super();
	}

	public ShiJian(Integer sid, String shijan, String yaoqiu, String beizhu, Integer sfno) {
		super();
		this.sid = sid;
		this.shijan = shijan;
		this.yaoqiu = yaoqiu;
		this.beizhu = beizhu;
		this.sfno = sfno;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getShijan() {
		return shijan;
	}
	public void setShijan(String shijan) {
		this.shijan = shijan;
	}
	public String getYaoqiu() {
		return yaoqiu;
	}
	public void setYaoqiu(String yaoqiu) {
		this.yaoqiu = yaoqiu;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getSfno() {
		return sfno;
	}

	public void setSfno(Integer sfno) {
		this.sfno = sfno;
	}
	
}
