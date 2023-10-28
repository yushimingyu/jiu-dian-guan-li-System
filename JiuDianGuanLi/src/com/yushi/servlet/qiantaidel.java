package com.yushi.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.QianTaiDao;
import com.yushi.entity.QianTai;

/**
 * Servlet implementation class qiantaidel
 */
@WebServlet("/qiantai/qiantaiDel.action")
public class qiantaidel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qiantaidel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		int gid = Integer.parseInt(request.getParameter("gid"));

		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(d);
		QianTaiDao dao = new QianTaiDao();
		QianTai qiantai = dao.SelectById(gid);
		QianTai qt= new QianTai(qiantai.getGid(),qiantai.getGname(),qiantai.getGtel(),qiantai.getGidc(),qiantai.getGhsno(),qiantai.getGyystate(),qiantai.getGruzhutime(),now,qiantai.getGhstate(),qiantai.getZhifustate(),qiantai.getBeizhu()+"->{[数据来源]->删除}",qiantai.getHuafei());
		
		dao.RiZhiinsert(qt);
		int num = dao.deleteById(gid);
		response.sendRedirect("List.jsp");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
