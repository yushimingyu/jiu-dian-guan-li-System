package com.yushi.servlet.fangjian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.ShiJianDao;
import com.yushi.entity.ShiJian;

/**
 * Servlet implementation class shijianadd
 */
@WebServlet("/qiantai/shijianadd.action")
public class shijianadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shijianadd() {
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
		
		
		String shijian= request.getParameter("shijian");
		String yaoqiu = request.getParameter("yaoqiu");
		String beizhu = request.getParameter("beizhu");
		String sfno = request.getParameter("sfno");
		
		
		ShiJian f= new ShiJian(null,shijian,yaoqiu,beizhu,Integer.parseInt(sfno));
		ShiJianDao dao = new ShiJianDao();
		dao.insert(f);
		
		
		
		
		response.sendRedirect("shijianlist1.jsp");
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
