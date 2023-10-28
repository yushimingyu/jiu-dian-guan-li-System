package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yushi.entity.FangJian;
import com.yushi.entity.QianTai;




public class FangJianDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
///////////////////////////////////////////////////////////////////////////////////////////////
//������ͨ������Ų�ѯ��Ϣ�ķ���
//////////////////////////////////////////////////////////////////////////////////
	public FangJian selectByFno(int fno){
		String sql = "select * from fang_jian_table where fno=?";
		try{
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,fno);
			rs = stmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				int gfno=rs.getInt("fno");
				String zhuangtai = rs.getString("zhuang_tai");
				String qdlpass= rs.getString("lei_xing");
				String jiage= rs.getString("jiange");
				return new FangJian(id,gfno,zhuangtai,qdlpass,jiage);
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
///////////////////////////////////////////////////////////////////////////////////////////////
//�����Ǹ�����Ϣ�ķ���
///////////////////////////////////////////////////////////////////////////////////////////
	public void insert(FangJian f){
		String sql = "insert into fang_jian_table values (null,?,?,?,?)";//��Ӧ��SQL�����
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,f.getFno() );
			stmt.setString(2,f.getZhuangtai());
			stmt.setString(3,f.getLeixing());
			stmt.setString(4,f.getJiage());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����Ϣʧ�ܣ�ԭ��������Ӵ���");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}		
	}
///////////////////////////////////////////////////////////////////////////////////////////////
//������ͨ����idɾ����Ϣ�ķ���
///////////////////////////////////////////////////////////////////////////////////////////////
public void deleteById(int id){
	String sql = "delete from fang_jian_table where id=?";//��Ӧ��SQL�����
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
//////////////////////////////////////////////////////////////////////////////////////////
//������ͨ����ID���Ĳ�ѯ����
////////////////////////////////////////////////////////////////////////////////////////////////
public FangJian selectById(int id){
	String sql = "select * from fang_jian_table where id=?";
	try{
		conn = BaseDao.getConn();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);
		rs = stmt.executeQuery();
		if(rs.next()){
			int iid = rs.getInt("id");
			int gfno=rs.getInt("fno");
			String zhuangtai = rs.getString("zhuang_tai");
			String qdlpass= rs.getString("lei_xing");
			String jiage= rs.getString("jiange");
			return new FangJian(iid,gfno,zhuangtai,qdlpass,jiage);
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
public void Update(FangJian f){
	String sql = "update fang_jian_table set fno=?,zhuang_tai=?,lei_xing=?,jiange=? where id=?";
	
	try {
		conn = BaseDao.getConn();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1,f.getFno());
		stmt.setString(2,f.getZhuangtai());
		stmt.setString(3,f.getLeixing());
		stmt.setString(4,f.getJiage());
		stmt.setInt(5,f.getId());
		
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
//////////////////////////////////////////////////////////////////////////////////////////
//�����ǲ�ѯȫ����Ϣ�ķ���
//////////////////////////////////////////////////////////////////////////////////////////////
public List selectAll(){
	String sql = "select * from fang_jian_table";//��Ӧ��SQL�����
	List list = new ArrayList();//����һ������
	
		try {
			this.conn = BaseDao.getConn();
			this.stmt = conn.prepareStatement(sql);
			this.rs = stmt.executeQuery();
			while(rs.next()){
				int a= rs.getInt("id");
				int s =rs.getInt("fno");
				String d =rs.getString("zhuang_tai");
				String g =rs.getString("lei_xing");
				String jiage =rs.getString("jiange");
				FangJian f= new FangJian(a,s,d,g,jiage);
				list.add(f);
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
//////////////////////////////////////////////////////////////////////////////////////////
//�����ǶԷ���ŵĸ��·���
//////////////////////////////////////////////////////////////////////////////////////////
public void insert1(int asd ,String d){
	String sql = "update fang_jian_table set zhuang_tai=? where fno=?";//��Ӧ��SQL�����
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

///////////////////////////////////////////////////////////////////////////////////////////////





}