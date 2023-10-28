package com.yushi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yushi.Dao.JingliDao;
import com.yushi.entity.Jingli;

/**
 * Servlet implementation class JingliLoginservlet
 */
@WebServlet("/JLogin.action")
public class JingliLoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JingliLoginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminsno = request.getParameter("adminsno");
		String adminpass = request.getParameter("adminpass");
		
		Jingli admin = new JingliDao().selectByName(adminsno);
		if(admin!=null&&admin.getAdminsno().equals(adminsno)&&admin.getAdminpass().equals(adminpass)){
			
			
			HttpSession session = request.getSession();
			session.setAttribute("AdminLogin", admin);
			
			
			response.sendRedirect("guanli/List1.jsp");
		}else{
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("JLogin.jsp").forward(request, response);
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
