package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yushi.entity.FuWu;
import com.yushi.entity.ShiJian;

public class ShiJianDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
///////////////////////////////////////////////////////////////////////////////////////////////
//�����Ǹ�����Ϣ�ķ���
///////////////////////////////////////////////////////////////////////////////////////////
	public void insert(ShiJian f){
		String sql = "insert into shi_jian_table values (null,?,?,?,?)";//��Ӧ��SQL�����
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,f.getShijan());
			stmt.setString(2,f.getYaoqiu());
			stmt.setString(3,f.getBeizhu());
			stmt.setInt(4, f.getSfno() );
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
	
///////////////////////////////////////////////////////////////////////////////////////////	
	public List<ShiJian> selectByshijianId(int id){
		String sql = "select * from shi_jian_table where sfno=?";
		List<ShiJian> list = new ArrayList<ShiJian>();
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				int y = rs.getInt("sid");
				String s = rs.getString("shijian");
				String y1 = rs.getString("yaoqiu");
				String b = rs.getString("beizhu");
				int sf = rs.getInt("sfno");
				ShiJian beh = new ShiJian(y, s, y1, b,sf);
				list.add(beh);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ������Ϣʧ�ܣ�ԭ�����ݶ�ȡ����");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
		
	}	
///////////////////////////////////////////////////////////////////////////////////////////	
	
///////////////////////////////////////////////////////////////////////////////////////////	
	
	public void deleteById(int id){
		String sql = "delete from shi_jian_table where sid=?";//��Ӧ��SQL�����
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
	
	
	
	
	public List selectAll(){
		String sql = "select * from shi_jian_table";//��Ӧ��SQL�����
		List list = new ArrayList();//����һ������

		try {
			this.conn = BaseDao.getConn();
			this.stmt = conn.prepareStatement(sql);
			this.rs = stmt.executeQuery();
			while(rs.next()){
				int y = rs.getInt("sid");
				String s = rs.getString("shijian");
				String y1 = rs.getString("yaoqiu");
				String b = rs.getString("beizhu");
				int sf = rs.getInt("sfno");
				ShiJian beh = new ShiJian(y, s, y1, b,sf);
				list.add(beh);
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
	
	
	
	
	
	
	
	
	
	
	
	
}
