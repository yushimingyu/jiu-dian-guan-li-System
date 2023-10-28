package com.yushi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yushi.entity.QianTai;
import com.yushi.entity.Rizhi;

public class RizhiDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public List selectAll(){
		String sql = "select * from rizhi order by gid desc";//对应的SQL的语句
		List list = new ArrayList();//创建一个集合
		
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
					Rizhi ri= new Rizhi(gid,gname,gtel,gidc,ghsno,gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
					list.add(ri);
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
