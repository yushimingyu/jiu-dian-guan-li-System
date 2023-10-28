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
 * Servlet implementation class qianadminLoginservlet
 */
@WebServlet("/QLogin.action")
public class qianadminLoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qianadminLoginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qsno = request.getParameter("qsno");
		String pass = request.getParameter("pass");
		
		qianadmin admin = new qianadminDao().selectByName(qsno);
		if(admin!=null&&admin.getQsno().equals(qsno)&&admin.getQdlpass().equals(pass)){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("qianadminLogin", admin);
			
			
			
			response.sendRedirect("qiantai/List.jsp");
		}else{
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("QLogin.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
