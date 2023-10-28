package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yushi.entity.QianTai;



public class QianTaiDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public List selectAll(){
		String sql = "select * from qiantaiguanli";//��Ӧ��SQL�����
		List list = new ArrayList();//����һ������
		
			try {
				this.conn = BaseDao.getConn();
				this.stmt = conn.prepareStatement(sql);
				this.rs = stmt.executeQuery();
				while(rs.next()){
					int gid= rs.getInt("gid");
					String gname =rs.getString("gname");
					String gtel =rs.getString("gtel");
					String gidc =rs.getString("gidc");
					//String ghsno =rs.getString("ghsno");
					int ghsno =rs.getInt("ghsno");
					String gyystate =rs.getString("gyystate");
					String gruzhutime =rs.getString("gruzhutime");
					String gouttime =rs.getString("gouttime");
					String ghstate =rs.getString("ghstate");
					String zhifustate =rs.getString("zhifustate");
					String beizhu =rs.getString("beizhu");
					int huafei =rs.getInt("huafei");
					QianTai qiantai= new QianTai(gid,gname,gtel,gidc,ghsno,gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
					list.add(qiantai);
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
	public boolean insert(QianTai qiantai){
		String sql = "insert into qiantaiguanli values (null,?,?,?,?,?,?,?,?,?,?,?)";//��Ӧ��SQL�����
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,qiantai.getGname() );
			stmt.setString(2,qiantai.getGtel());
			stmt.setString(3, qiantai.getGidc());
			//stmt.setString(4, qiantai.getGhsno());
			stmt.setInt(4, qiantai.getGhsno());
			
			
			stmt.setString(5,qiantai.getGyystate() );
			stmt.setString(6, qiantai.getGruzhutime());
			stmt.setString(7,qiantai.getGouttime() );
			stmt.setString(8,qiantai.getGhstate() );
			stmt.setString(9, qiantai.getZhifustate());
			stmt.setString(10,qiantai.getBeizhu() );
			stmt.setInt(11,qiantai.getHuafei() );
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
				
	}
	public int deleteById(int gid){
		String sql = "delete from qiantaiguanli where gid=?";//��Ӧ��SQL�����
		try {
			conn= BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,gid);//�����һ�� �� ��ֵ
			int num = stmt.executeUpdate();
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
			
		}finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
		
	}
	///////////////////////////////////////////////////////////////////////////
	public boolean UpdateId(int gid,QianTai qiantai){
		String sql = "update qiantaiguanli set gname=?,gtel=?,gidc=?,ghsno=?,gyystate=?,"
				+ "gruzhutime=?,gouttime=?,ghstate=?,zhifustate=?,beizhu=?,huafei=? "
				+ "where gid=?";
		
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,qiantai.getGname() );
			stmt.setString(2,qiantai.getGtel());
			stmt.setString(3, qiantai.getGidc());
			//stmt.setString(4, qiantai.getGhsno());
			stmt.setInt(4, qiantai.getGhsno());
			
			
			stmt.setString(5,qiantai.getGyystate() );
			stmt.setString(6, qiantai.getGruzhutime());
			stmt.setString(7,qiantai.getGouttime() );
			stmt.setString(8,qiantai.getGhstate() );
			stmt.setString(9, qiantai.getZhifustate());
			stmt.setString(10,qiantai.getBeizhu() );
			stmt.setInt(11,qiantai.getHuafei() );
			stmt.setInt(12, gid);
			
			
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	public QianTai SelectById(int id){
		String sql = "select * from qiantaiguanli where gid=?";//��Ӧ��SQL�����
		List<QianTai> list = new ArrayList();//����һ������
		
			try {
				this.conn = BaseDao.getConn();
				this.stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				this.rs = stmt.executeQuery();
				if(rs.next()){
					int gid= rs.getInt("gid");
					String gname =rs.getString("gname");
					String gtel =rs.getString("gtel");
					String gidc =rs.getString("gidc");
					//String ghsno =rs.getString("ghsno");
					int ghsno =rs.getInt("ghsno");
					
					String gyystate =rs.getString("gyystate");
					String gruzhutime =rs.getString("gruzhutime");
					String gouttime =rs.getString("gouttime");
					String ghstate =rs.getString("ghstate");
					String zhifustate =rs.getString("zhifustate");
					String beizhu =rs.getString("beizhu");
					int huafei =rs.getInt("huafei");
					QianTai qiantai= new QianTai(gid,gname,gtel,gidc,ghsno,gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
					return qiantai;
				}
				throw new RuntimeException("��ѯ��Ϣʧ�ܣ�ԭ�򣺲�����");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("��ѯ��Ϣʧ�ܣ�ԭ�����ݶ�ȡ����");
			} finally{
				BaseDao.closeAll(conn, stmt, rs);//�ر�
			}
		
		
		
	}
	public void Update(QianTai qiantai){
		String sql = "update qiantaiguanli set gname=?,gtel=?,gidc=?,ghsno=?,gyystate=?,"
				+ "gruzhutime=?,gouttime=?,ghstate=?,zhifustate=?,beizhu=?,huafei=? "
				+ "where gid=?";
		
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,qiantai.getGname() );
			stmt.setString(2,qiantai.getGtel());
			stmt.setString(3, qiantai.getGidc());
			//stmt.setString(4, qiantai.getGhsno());
			
			stmt.setInt(4, qiantai.getGhsno());
			
			stmt.setString(5,qiantai.getGyystate() );
			stmt.setString(6, qiantai.getGruzhutime());
			stmt.setString(7,qiantai.getGouttime() );
			stmt.setString(8,qiantai.getGhstate() );
			stmt.setString(9, qiantai.getZhifustate());
			stmt.setString(10,qiantai.getBeizhu() );
			stmt.setInt(11,qiantai.getHuafei() );
			stmt.setInt(12, qiantai.getGid());
			
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
///////////////////////////////////////////////////////////////////////////////////////////	
	
	public List<QianTai> selectByQianTaiId(int id){
		String sql = "select * from qiantaiguanli where ghsno=?";
		List<QianTai> list = new ArrayList<QianTai>();
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				int gid= rs.getInt("gid");
				String gname =rs.getString("gname");
				String gtel =rs.getString("gtel");
				String gidc =rs.getString("gidc");
				//String ghsno =rs.getString("ghsno");
				int ghsno =rs.getInt("ghsno");
				String gyystate =rs.getString("gyystate");
				String gruzhutime =rs.getString("gruzhutime");
				String gouttime =rs.getString("gouttime");
				String ghstate =rs.getString("ghstate");
				String zhifustate =rs.getString("zhifustate");
				String beizhu =rs.getString("beizhu");
				int huafei =rs.getInt("huafei");
				QianTai q= new QianTai(gid,gname,gtel,gidc,ghsno,gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
				list.add(q);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ϣʧ�ܣ�ԭ�����ݶ�ȡ����");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////	
	public void insert11(int asd ,String d){
		String sql = "update qiantaiguanli set gouttime=? where gid=?";//��Ӧ��SQL�����
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,d);
			stmt.setInt(2,asd);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���Fang��Ϣʧ�ܣ�ԭ��������Ӵ���");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}		
	}
/////////////////////////////////////////////////////////////////////////////////////////////	
	
//todo ��־
	
	
	
	
	public List RiZhiselectAll(){
		String sql = "select * from rizhi";//��Ӧ��SQL�����
		List list = new ArrayList();//����һ������
		
			try {
				this.conn = BaseDao.getConn();
				this.stmt = conn.prepareStatement(sql);
				this.rs = stmt.executeQuery();
				while(rs.next()){
					int gid= rs.getInt("gid");
					String gname =rs.getString("gname");
					String gtel =rs.getString("gtel");
					String gidc =rs.getString("gidc");
					//String ghsno =rs.getString("ghsno");
					int ghsno =rs.getInt("ghsno");
					String gyystate =rs.getString("gyystate");
					String gruzhutime =rs.getString("gruzhutime");
					String gouttime =rs.getString("gouttime");
					String ghstate =rs.getString("ghstate");
					String zhifustate =rs.getString("zhifustate");
					String beizhu =rs.getString("beizhu");
					int huafei =rs.getInt("huafei");
					QianTai qiantai= new QianTai(gid,gname,gtel,gidc,ghsno,gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
					list.add(qiantai);
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
//////////////////////////////////////////////////////////////////////////////////////////////	
	public void RiZhiinsert(QianTai qiantai){
		String sql = "insert into rizhi values (null,?,?,?,?,?,?,?,?,?,?,?)";//��Ӧ��SQL�����
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,qiantai.getGname() );
			stmt.setString(2,qiantai.getGtel());
			stmt.setString(3, qiantai.getGidc());
			//stmt.setString(4, qiantai.getGhsno());
			stmt.setInt(4, qiantai.getGhsno());
			
			
			stmt.setString(5,qiantai.getGyystate() );
			stmt.setString(6, qiantai.getGruzhutime());
			stmt.setString(7,qiantai.getGouttime() );
			stmt.setString(8,qiantai.getGhstate() );
			stmt.setString(9, qiantai.getZhifustate());
			stmt.setString(10,qiantai.getBeizhu() );
			stmt.setInt(11,qiantai.getHuafei() );
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
				
	}

	
}
