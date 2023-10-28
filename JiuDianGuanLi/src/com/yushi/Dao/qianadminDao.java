package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yushi.entity.QianTai;
import com.yushi.entity.qianadmin;

public class qianadminDao {
	
		private Connection conn;
		private PreparedStatement stmt;
		private ResultSet rs;
		public qianadmin selectByName(String qsno){
			String sql = "select * from qiantaiadmintablie where qsno=?";
			try{
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,qsno);
				rs = stmt.executeQuery();
				if(rs.next()){
					int id = rs.getInt("qid");
					String sno=rs.getString("qsno");
					String qname = rs.getString("qname");
					String qdlpass= rs.getString("qdlpass");
					
				
					return new qianadmin(id,sno,qname,qdlpass);
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
		
		
		
	    public qianadmin selectById(int qid){
			String sql = "select * from qiantaiadmintablie where qid=?";
			try{
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1,qid);
				rs = stmt.executeQuery();
				if(rs.next()){
					int id = rs.getInt("qid");
					String qsno=rs.getString("qsno");
					String qname = rs.getString("qname");
					String qdlpass= rs.getString("qdlpass");
					String qsex =rs.getString("qsex");
					String qage =rs.getString("qage");
					String qidc =rs.getString("qidc");
					String gongzhi=rs.getString("gongzhi");
				
					return new qianadmin(id,qsno,qname,qdlpass,qsex,qage,qidc,gongzhi);
				}
				throw new RuntimeException("查询信息失败，原因：不存在");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("查询信息失败，原因：数据读取错误");
			} finally {
				BaseDao.closeAll(conn, stmt, rs);
			}
		}

		public List selectAll(){
			String sql = "select * from qiantaiadmintablie";//对应的SQL的语句
			List list = new ArrayList();//创建一个集合
			
				try {
					this.conn = BaseDao.getConn();
					this.stmt = conn.prepareStatement(sql);
					this.rs = stmt.executeQuery();
					while(rs.next()){
						int qid= rs.getInt("qid");
						String qsno =rs.getString("qsno");
						String qname =rs.getString("qname");
						String qdlpass =rs.getString("qdlpass");
						String qsex =rs.getString("qsex");
						String qage =rs.getString("qage");
						String qidc =rs.getString("qidc");
						String gongzhi=rs.getString("gongzhi");
					qianadmin admin = new qianadmin(qid,qsno,qname,qdlpass,qsex,qage,qidc,gongzhi);
						
						list.add(admin);
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
		public boolean insert(qianadmin admin){
			String sql = "insert into qiantaiadmintablie values (null,?,?,?,?,?,?,?)";//对应的SQL的语句
			try {
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,admin.getQsno() );
				stmt.setString(2,admin.getQname());
				stmt.setString(3, admin.getQdlpass());
				stmt.setString(4, admin.getQsex());
				stmt.setString(5,admin.getQage() );
				stmt.setString(6, admin.getQidc());
				stmt.setString(7,admin.getGoongzhi() );
			
				return stmt.executeUpdate()>0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			} finally{
				BaseDao.closeAll(conn, stmt, rs);
			}
					
		}
		public int deleteById(int qid){
			String sql = "delete from qiantaiadmintablie where qid=?";//对应的SQL的语句
			try {
				conn= BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1,qid);//导入第一个 ？ 的值
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
		
		public boolean UpdateId(int qid,qianadmin admin){
			String sql = "update qiantaiadmintablie set qsno=?,qname=?,qdlpass=?,qsex=?,qage=?,"
					+ "qidc=?,gongzhi=? where qid=?";
			
			try {
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,admin.getQsno() );
				stmt.setString(2,admin.getQname());
				stmt.setString(3, admin.getQdlpass());
				stmt.setString(4, admin.getQsex());
				stmt.setString(5,admin.getQage() );
				stmt.setString(6, admin.getQidc());
				stmt.setString(7,admin.getGoongzhi() );
				
				stmt.setInt(8, qid);
				
				
				return stmt.executeUpdate()>0;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				BaseDao.closeAll(conn, stmt, rs);
			}
		}
	
		public void Update(qianadmin admin){
			String sql = "update qiantaiadmintablie set qsno=?,qname=?,qdlpass=?,qsex=?,qage=?,"
					+ "qidc=?,gongzhi=? where qid=?";
			
			try {
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,admin.getQsno() );
				stmt.setString(2,admin.getQname());
				stmt.setString(3, admin.getQdlpass());
				stmt.setString(4, admin.getQsex());
				stmt.setString(5,admin.getQage() );
				stmt.setString(6, admin.getQidc());
				stmt.setString(7,admin.getGoongzhi() );
				
				stmt.setInt(8, admin.getQid());
				
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
