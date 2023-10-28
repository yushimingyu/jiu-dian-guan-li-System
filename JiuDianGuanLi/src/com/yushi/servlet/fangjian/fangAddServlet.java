package com.yushi.servlet.fangjian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.FangJianDao;
import com.yushi.Dao.QianTaiDao;
import com.yushi.entity.FangJian;
import com.yushi.entity.QianTai;

/**
 * Servlet implementation class fangAddServlet
 */
@WebServlet("/qiantai/fangjianadd.action")
public class fangAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fangAddServlet() {
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
		
		
		String fno = request.getParameter("fno");
		String zhuangtai = request.getParameter("zhuangtai");
		String leixing = request.getParameter("leixing");
		String jiage = request.getParameter("jiage");

		
		
		
		
	
		FangJian f= new FangJian(null,Integer.parseInt(fno),zhuangtai,leixing,jiage);
		FangJianDao dao = new FangJianDao();
		dao.insert(f);
	
		response.sendRedirect("fangjianlist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
