package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yushi.entity.Jingli;




public class JingliDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public Jingli selectByName(String adminsno){
		String sql = "select * from admintable where adminsno=?";
		try{
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,adminsno);
			rs = stmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("adminid");
				String sno=rs.getString("adminsno");
				String pass = rs.getString("adminpass");
				String name= rs.getString("jlname");
				return new Jingli(id,sno,pass,name);
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

}
