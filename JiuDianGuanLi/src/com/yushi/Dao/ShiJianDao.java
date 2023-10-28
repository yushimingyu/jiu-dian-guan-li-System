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
//以下是更新信息的方法
///////////////////////////////////////////////////////////////////////////////////////////
	public void insert(ShiJian f){
		String sql = "insert into shi_jian_table values (null,?,?,?,?)";//对应的SQL的语句
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
			throw new RuntimeException("添加信息失败，原因：数据添加错误");
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
			throw new RuntimeException("查询奖惩信息失败，原因：数据读取错误");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
		
	}	
///////////////////////////////////////////////////////////////////////////////////////////	
	
///////////////////////////////////////////////////////////////////////////////////////////	
	
	public void deleteById(int id){
		String sql = "delete from shi_jian_table where sid=?";//对应的SQL的语句
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
	
	
	
	
	public List selectAll(){
		String sql = "select * from shi_jian_table";//对应的SQL的语句
		List list = new ArrayList();//创建一个集合

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
			BaseDao.closeAll(conn, stmt, rs);//关闭
		}
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
