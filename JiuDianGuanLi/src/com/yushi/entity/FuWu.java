package com.yushi.entity;

public class FuWu {
	private Integer yid;
	private String yname;
	private String yidc;
	private String ytel;
	private String zhiwei;
	private Integer weizhi;
	private String xuqiu;
	private String beizhu;
	
	private FangJian fangjian;
	
	public FuWu() {
		super();
		this.fangjian =new FangJian();
	}
	
	public FuWu(Integer yid, String yname, String yidc, String ytel, String zhiwei, Integer weizhi, String xuqiu,
			String beizhu, FangJian fangjian) {
		super();
		this.yid = yid;
		this.yname = yname;
		this.yidc = yidc;
		this.ytel = ytel;
		this.zhiwei = zhiwei;
		this.weizhi = weizhi;
		this.xuqiu = xuqiu;
		this.beizhu = beizhu;
		this.fangjian = fangjian;
	}
	

	public FuWu(Integer yid, String yname, String yidc, String ytel, String zhiwei, Integer weizhi, String xuqiu,
			String beizhu) {
		super();
		this.yid = yid;
		this.yname = yname;
		this.yidc = yidc;
		this.ytel = ytel;
		this.zhiwei = zhiwei;
		this.weizhi = weizhi;
		this.xuqiu = xuqiu;
		this.beizhu = beizhu;
	}

	public Integer getYid() {
		return yid;
	}
	public void setYid(Integer yid) {
		this.yid = yid;
	}
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public String getYidc() {
		return yidc;
	}
	public void setYidc(String yidc) {
		this.yidc = yidc;
	}
	public String getYtel() {
		return ytel;
	}
	public void setYtel(String ytel) {
		this.ytel = ytel;
	}
	public String getZhiwei() {
		return zhiwei;
	}
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	public Integer getWeizhi() {
		return weizhi;
	}
	public void setWeizhi(Integer weizhi) {
		this.weizhi = weizhi;
	}
	public String getXuqiu() {
		return xuqiu;
	}
	public void setXuqiu(String xuqiu) {
		this.xuqiu = xuqiu;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public FangJian getFangjian() {
		return fangjian;
	}

	public void setFangjian(FangJian fangjian) {
		this.fangjian = fangjian;
	}
	
}
