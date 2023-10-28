package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yushi.entity.FangJian;
import com.yushi.entity.FuWu;



public class FuWuDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
//////////////////////////////////////////////////////////////////////////////////////////
//�����ǲ�ѯȫ����Ϣ�ķ���
//////////////////////////////////////////////////////////////////////////////////////////
	public List selectAll(){
		String sql = "select * from jiudian_fuwuyuan";//��Ӧ��SQL�����
		List list = new ArrayList();//����һ������

		try {
			this.conn = BaseDao.getConn();
			this.stmt = conn.prepareStatement(sql);
			this.rs = stmt.executeQuery();
			while(rs.next()){
				int yid= rs.getInt("yid");
				String yname =rs.getString("yname");
				String yidc =rs.getString("yidc");
				String ytel =rs.getString("ytel");
				
				String yzhiwei =rs.getString("yzhiwei");
				int weizhi =rs.getInt("weizhi");
				
				String xuqiu =rs.getString("xuqiu");
				String beizhu =rs.getString("beizhu");
				FuWu fw =new FuWu(yid,yname,yidc,ytel,yzhiwei,weizhi,xuqiu,beizhu);
				list.add(fw);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally{
			BaseDao.closeAll(conn, stmt, rs);//�ر�
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////
//�����������Ϣ�ķ���
///////////////////////////////////////////////////////////////////////////////////////////
	public void insert(FuWu f){
		String sql = "insert into jiudian_fuwuyuan values (null,?,?,?,?,?,?,?)";//��Ӧ��SQL�����
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,f.getYname());
			stmt.setString(2,f.getYidc());
			stmt.setString(3,f.getYtel());
			stmt.setString(4,f.getZhiwei());
			
			stmt.setInt(5,f.getWeizhi());
			stmt.setString(6,f.getXuqiu());
			stmt.setString(7,f.getBeizhu());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����Ϣʧ�ܣ�ԭ��������Ӵ���");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}		
	}	
///////////////////////////////////////////////////////////////////////////////////////////
	

	
	
//////////////////////////////////////////////////////////////////////////////////////////
//������ͨ����ID���Ĳ�ѯ����
////////////////////////////////////////////////////////////////////////////////////////////////
	public FuWu selectById(int id){
		String sql = "select * from jiudian_fuwuyuan where yid=?";
		try{
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			if(rs.next()){
				int yid = rs.getInt("yid");
				String yname=rs.getString("yname");
				String yidc = rs.getString("yidc");
				String ytel= rs.getString("ytel");
				String yz= rs.getString("yzhiwei");
				int we= rs.getInt("weizhi");
				String xu= rs.getString("xuqiu");
				String be= rs.getString("beizhu");
				
				
				
				return new FuWu(yid,yname,yidc,ytel,yz,we,xu,be);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			BaseDao.closeAll(conn, stmt, rs);
		}
	}	
//////////////////////////////////////////////////////////////////////////////////////////
//�����Ǹ���ȫ����Ϣ�ķ���
///////////////////////////////////////////////////////////////////////////////////////////
	public void Update(FuWu f){
		String sql = "update jiudian_fuwuyuan set yname=?,yidc=?,ytel=?,yzhiwei=?,weizhi=?,xuqiu=?,beizhu=? where yid=?";

		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,f.getYname());
			stmt.setString(2,f.getYidc());
			stmt.setString(3,f.getYtel());
			stmt.setString(4,f.getZhiwei());
			stmt.setInt(5,f.getWeizhi());
			stmt.setString(6,f.getXuqiu());
			stmt.setString(7,f.getBeizhu());
			
			stmt.setInt(8,f.getYid());

			int num = stmt.executeUpdate();
			if(num==0){
				throw new RuntimeException("�޸���Ϣʧ�ܣ�ԭ�򣺲�����");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�޸���Ϣʧ�ܣ�ԭ�������޸Ĵ���");
		}finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}	
///////////////////////////////////////////////////////////////////////////////////////////////
//������ͨ����idɾ����Ϣ�ķ���
///////////////////////////////////////////////////////////////////////////////////////////////
	public void deleteById(int id){
		String sql = "delete from jiudian_fuwuyuan where yid=?";//��Ӧ��SQL�����
		try {
			conn= BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);//�����һ�� �� ��ֵ
			int num = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
