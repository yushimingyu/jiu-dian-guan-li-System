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
//以下是通过房间号查询信息的方法
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
//以下是更新信息的方法
///////////////////////////////////////////////////////////////////////////////////////////
	public void insert(FangJian f){
		String sql = "insert into fang_jian_table values (null,?,?,?,?)";//对应的SQL的语句
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
			throw new RuntimeException("添加信息失败，原因：数据添加错误");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}		
	}
///////////////////////////////////////////////////////////////////////////////////////////////
//以下是通过“id删除信息的方法
///////////////////////////////////////////////////////////////////////////////////////////////
public void deleteById(int id){
	String sql = "delete from fang_jian_table where id=?";//对应的SQL的语句
	try {
		conn= BaseDao.getConn();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);//导入第一个 ？ 的值
		int num = stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		BaseDao.closeAll(conn, stmt, rs);
	}
}
//////////////////////////////////////////////////////////////////////////////////////////
//以下是通过“ID”的查询方法
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
//以下是更新全部信息的方法
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
			throw new RuntimeException("修改信息失败，原因：不存在");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("修改信息失败，原因：数据修改错误");
	}finally{
		BaseDao.closeAll(conn, stmt, rs);
	}
}
//////////////////////////////////////////////////////////////////////////////////////////
//以下是查询全部信息的方法
//////////////////////////////////////////////////////////////////////////////////////////////
public List selectAll(){
	String sql = "select * from fang_jian_table";//对应的SQL的语句
	List list = new ArrayList();//创建一个集合
	
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
			BaseDao.closeAll(conn, stmt, rs);//关闭
		}
}
//////////////////////////////////////////////////////////////////////////////////////////
//以下是对房间号的更新方法
//////////////////////////////////////////////////////////////////////////////////////////
public void insert1(int asd ,String d){
	String sql = "update fang_jian_table set zhuang_tai=? where fno=?";//对应的SQL的语句
	try {
		conn = BaseDao.getConn();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,d);
		stmt.setInt(2,asd);
		stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("添加Fang信息失败，原因：数据添加错误");
	} finally{
		BaseDao.closeAll(conn, stmt, rs);
	}		
}

///////////////////////////////////////////////////////////////////////////////////////////////





}