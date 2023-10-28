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
//以下是查询全部信息的方法
//////////////////////////////////////////////////////////////////////////////////////////
	public List selectAll(){
		String sql = "select * from jiudian_fuwuyuan";//对应的SQL的语句
		List list = new ArrayList();//创建一个集合

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
			BaseDao.closeAll(conn, stmt, rs);//关闭
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////
//以下是添加信息的方法
///////////////////////////////////////////////////////////////////////////////////////////
	public void insert(FuWu f){
		String sql = "insert into jiudian_fuwuyuan values (null,?,?,?,?,?,?,?)";//对应的SQL的语句
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
			throw new RuntimeException("添加信息失败，原因：数据添加错误");
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}		
	}	
///////////////////////////////////////////////////////////////////////////////////////////
	

	
	
//////////////////////////////////////////////////////////////////////////////////////////
//以下是通过“ID”的查询方法
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
//以下是更新全部信息的方法
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
///////////////////////////////////////////////////////////////////////////////////////////////
//以下是通过“id删除信息的方法
///////////////////////////////////////////////////////////////////////////////////////////////
	public void deleteById(int id){
		String sql = "delete from jiudian_fuwuyuan where yid=?";//对应的SQL的语句
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
