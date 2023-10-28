package com.yushi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.FangJianDao;
import com.yushi.Dao.QianTaiDao;

import com.yushi.entity.QianTai;


/**
 * Servlet implementation class qiantaiupd
 */
@WebServlet("/qiantai/qiantaiupd.action")
public class qiantaiupd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qiantaiupd() {
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
		int id = Integer.parseInt(request.getParameter("gid"));
		
		String gname = request.getParameter("gname");
		String gtel = request.getParameter("gtel");
		String gidc = request.getParameter("gidc");
		String ghsno = request.getParameter("ghsno");
		String gyystate = request.getParameter("gyystate");
		String gruzhutime = request.getParameter("gruzhutime");
		String gouttime = request.getParameter("gouttime");
		String ghstate = request.getParameter("ghstate");
		String zhifustate = request.getParameter("zhifustate");
		String beizhu = request.getParameter("beizhu");
		int huafei = Integer.parseInt(request.getParameter("huafei"));
		QianTai qiantai= new QianTai(id,gname,gtel,gidc,Integer.parseInt(ghsno),gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
		QianTaiDao dao= new QianTaiDao();
		dao.Update(qiantai);
		FangJianDao kao = new FangJianDao();
		kao.insert1(Integer.parseInt(ghsno),ghstate);
		
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(d);
		
		
		QianTai qt= new QianTai(qiantai.getGid(),qiantai.getGname(),qiantai.getGtel(),qiantai.getGidc(),qiantai.getGhsno(),qiantai.getGyystate(),qiantai.getGruzhutime(),now,ghstate,qiantai.getZhifustate(),qiantai.getBeizhu()+"->{[数据来源]->编辑}",qiantai.getHuafei());
		
		dao.RiZhiinsert(qt);
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
