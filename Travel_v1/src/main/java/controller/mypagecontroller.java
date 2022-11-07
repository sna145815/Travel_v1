package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.usermodel;

import service.userservice;

@WebServlet("/mypage")
public class mypagecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public mypagecontroller() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id");
		
		usermodel user = new usermodel();
		
		userservice service = new userservice();
		
		user = service.Selectuser(id);
		
		//오류 처리 필요
		request.setAttribute("user", user);
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mypage.jsp");
	    rq.forward(request, response);   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   		
		String pwd = request.getParameter("pwd");
		String uppwd = request.getParameter("uppwd");
		String uppwdr = request.getParameter("pwdr");
		
		HttpSession session = request.getSession(); 
		String id = (String) session.getAttribute("id");
		
		userservice service = new userservice();
		
		if(service.Checkpwd(pwd, id) == 1)
		{
			if(uppwd.equals(uppwdr))
			{
				if(service.Updatepwd(uppwd, id) == 1)
				{
					request.setAttribute("Result", true);
				}
				else 
				{	
					request.setAttribute("Result", false);
				}
			}
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/updateresult.jsp");
		    rq.forward(request, response);
		} 
		else
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mypage.jsp");
		    rq.forward(request, response);
		}	
	}
}