package com.yushi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yushi.Dao.qianadminDao;
import com.yushi.entity.qianadmin;

/**
 * Servlet implementation class qianadminupdservlet
 */
@WebServlet("/guanli/qianadminupd.action")
public class qianadminupdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qianadminupdservlet() {
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
		int id = Integer.parseInt(request.getParameter("qid"));
		
		String qsno = request.getParameter("qsno");
		String qname = request.getParameter("qname");
		String qdlpass = request.getParameter("qdlpass");
		String qsex = request.getParameter("qsex");
		String qage = request.getParameter("qage");
		String qidc = request.getParameter("qidc");
		String gongzhi = request.getParameter("gongzhi");
		qianadmin admin = new qianadmin(id,qsno,qname,qdlpass,qsex,qage,qidc,gongzhi);
		qianadminDao Dao = new qianadminDao();
		Dao.Update(admin);
		response.sendRedirect("List1.jsp");
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
