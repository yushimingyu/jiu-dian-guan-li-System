package com.yushi.servlet.fuwuyuan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yushi.Dao.FuWuDao;
import com.yushi.entity.FuWu;

/**
 * Servlet implementation class fuwuinfoupd
 */
@WebServlet("/guanli/fuwuinfoupd.action")
public class fuwuinfoupd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fuwuinfoupd() {
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
		
		int yid = Integer.parseInt(request.getParameter("yid"));
		String yname = request.getParameter("yname");
		String yidc = request.getParameter("yidc");
		String ytel = request.getParameter("ytel");
		String zhiwei = request.getParameter("zhiwei");
		String weizhi = request.getParameter("weizhi");
		String xuqiu = request.getParameter("xuqiu");
		String beizhu = request.getParameter("beizhu");
		

		
		
		

		FuWu f= new FuWu(yid,yname,yidc,ytel,zhiwei,Integer.parseInt(weizhi),xuqiu,beizhu);
		FuWuDao dao = new FuWuDao();
	
		dao.Update(f);
	
		response.sendRedirect("fuwuinfolist.jsp");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
