package com.yushi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.FangJianDao;
import com.yushi.Dao.QianTaiDao;
import com.yushi.entity.QianTai;

/**
 * Servlet implementation class qiantaiadd
 */
@WebServlet("/qiantai/ADD.action")
public class qiantaiadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qiantaiadd() {
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
		QianTai qiantai= new QianTai(null,gname,gtel,gidc,Integer.parseInt(ghsno),gyystate,gruzhutime,gouttime,ghstate,zhifustate,beizhu,huafei);
		QianTaiDao dao = new QianTaiDao();
		dao.insert(qiantai);
		FangJianDao kao = new FangJianDao();
		kao.insert1(Integer.parseInt(ghsno),ghstate);
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
