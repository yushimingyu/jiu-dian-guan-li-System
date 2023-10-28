package com.yushi.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	//创建
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//登录数据库
	public static Connection getConn() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiudianguanli",
				"root","Yushimingyu.1");
		return conn;
		
		
	}
	//关闭数据库
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
