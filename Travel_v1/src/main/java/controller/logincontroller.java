package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.usermodel;
import service.userservice;



@WebServlet("/login")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public logincontroller() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/loginpage.jsp");
	    rq.forward(request, response);     
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
	
		usermodel model=new usermodel();
		model.setId(id);
		model.setPwd(pwd);
		
		
		userservice  dao=new userservice();
		int result=dao.findbyuserid(model);
		

		
	
		if(result==1)
		{
			
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mainpage.jsp");
		    rq.forward(request, response);     
		}
		else
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/loginpage.jsp");
		    rq.forward(request, response);     
		}
		    
	
	}

}
