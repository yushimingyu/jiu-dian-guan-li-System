package com.yushi.entity;

public class QianTai {
	private Integer gid;//编号
	private String gname;//顾客姓名
	private String gtel;//顾客电话
	private String gidc;//顾客身份证
	
	
	
	//private String ghsno;//顾客房间编号
	
	private Integer ghsno;//顾客房间编号
	
	private FangJian fangjian;
	

	private String gyystate;//顾客预约状态
	private String gruzhutime;//顾客入住时间
	private String gouttime;//顾客离开时间
	private String ghstate;//顾客房间状态
	private String zhifustate;//支付状态
	private String beizhu;//备注
	private Integer huafei;//花费
	////////////////////////////////////////////////////////////////////////
	public QianTai() {
		super();
		this.fangjian =new FangJian();
	}
	public QianTai(Integer gid, String gname, String gtel, String gidc, Integer ghsno, String gyystate,
			String gruzhutime, String gouttime, String ghstate, String zhifustate, String beizhu, Integer huafei) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gtel = gtel;
		this.gidc = gidc;
		this.ghsno = ghsno;
		this.gyystate = gyystate;
		this.gruzhutime = gruzhutime;
		this.gouttime = gouttime;
		this.ghstate = ghstate;
		this.zhifustate = zhifustate;
		this.beizhu = beizhu;
		this.huafei = huafei;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGtel() {
		return gtel;
	}
	public void setGtel(String gtel) {
		this.gtel = gtel;
	}
	public String getGidc() {
		return gidc;
	}
	public void setGidc(String gidc) {
		this.gidc = gidc;
	}
	public Integer getGhsno() {
		return ghsno;
	}
	public void setGhsno(Integer ghsno) {
		this.ghsno = ghsno;
	}
	public String getGyystate() {
		return gyystate;
	}
	public void setGyystate(String gyystate) {
		this.gyystate = gyystate;
	}
	public String getGruzhutime() {
		return gruzhutime;
	}
	public void setGruzhutime(String gruzhutime) {
		this.gruzhutime = gruzhutime;
	}
	public String getGouttime() {
		return gouttime;
	}
	public void setGouttime(String gouttime) {
		this.gouttime = gouttime;
	}
	public String getGhstate() {
		return ghstate;
	}
	public void setGhstate(String ghstate) {
		this.ghstate = ghstate;
	}
	public String getZhifustate() {
		return zhifustate;
	}
	public void setZhifustate(String zhifustate) {
		this.zhifustate = zhifustate;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Integer getHuafei() {
		return huafei;
	}
	public void setHuafei(Integer huafei) {
		this.huafei = huafei;
	}
	public FangJian getFangjian() {
		return fangjian;
	}
	public void setFangjian(FangJian fangjian) {
		this.fangjian = fangjian;
	}
	public QianTai(Integer gid, String gname, String gtel, String gidc, Integer ghsno, FangJian fangjian,
			String gyystate, String gruzhutime, String gouttime, String ghstate, String zhifustate, String beizhu,
			Integer huafei) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gtel = gtel;
		this.gidc = gidc;
		this.ghsno = ghsno;
		this.fangjian = fangjian;
		this.gyystate = gyystate;
		this.gruzhutime = gruzhutime;
		this.gouttime = gouttime;
		this.ghstate = ghstate;
		this.zhifustate = zhifustate;
		this.beizhu = beizhu;
		this.huafei = huafei;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////


	
}