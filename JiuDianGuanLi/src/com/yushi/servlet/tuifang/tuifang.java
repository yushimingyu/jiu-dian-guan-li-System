package com.yushi.servlet.tuifang;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.FangJianDao;
import com.yushi.Dao.QianTaiDao;
import com.yushi.entity.QianTai;

/**
 * Servlet implementation class tuifang
 */
@WebServlet("/qiantai/tuifang.action")
public class tuifang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tuifang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		
		
		
		String fno = request.getParameter("id");
		
		FangJianDao dao = new FangJianDao();
		
		
		
		dao.insert1(Integer.parseInt(fno), "空");
		
		
		QianTaiDao dao1= new QianTaiDao();
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(d);
		List<QianTai>list = dao1.selectByQianTaiId(Integer.parseInt(fno));
		for(QianTai qiantai : list){
			dao1.insert11(qiantai.getGid(), now);
			QianTai qt= new QianTai(qiantai.getGid(),qiantai.getGname(),qiantai.getGtel(),qiantai.getGidc(),qiantai.getGhsno(),qiantai.getGyystate(),qiantai.getGruzhutime(),now,qiantai.getGhstate(),qiantai.getZhifustate(),qiantai.getBeizhu()+"->{[数据来源]->退房}",qiantai.getHuafei());
			
			dao1.RiZhiinsert(qt);
			
			
			int num = dao1.deleteById(qiantai.getGid());
		}
		
			
		response.sendRedirect("tuifang.jsp");
			
		
	
		
		
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
