package com.yushi.entity;

import java.util.ArrayList;
import java.util.List;



public class FangJian {
	private Integer id;
	
	private Integer fno;

	private String zhuangtai;
	private String leixing;
	private String jiage;
	
	private List<QianTai> qiantai;
	
	
	public FangJian() {
		super();
		this.qiantai =new ArrayList<QianTai>();
	}
	public FangJian(Integer id, Integer fno, String zhuangtai, String leixing, String jiage) {
		super();
		this.id = id;
		this.fno = fno;
		this.zhuangtai = zhuangtai;
		this.leixing = leixing;
		this.jiage = jiage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFno() {
		return fno;
	}
	public void setFno(Integer fno) {
		this.fno = fno;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public String getJiage() {
		return jiage;
	}
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	public List<QianTai> getQiantai() {
		return qiantai;
	}
	public void setQiantai(List<QianTai> qiantai) {
		this.qiantai = qiantai;
	}


}
