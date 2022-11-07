package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.userservice;

@WebServlet("/deleteuser")
public class deleteusercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteusercontroller() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/deleteuser.jsp");
	    rq.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   		
		String pwd = request.getParameter("pwd");
		String pwdr = request.getParameter("pwdr");
		
		HttpSession session = request.getSession(); 
		String id = (String) session.getAttribute("id");
		
		userservice service = new userservice();
		
		if(service.Checkpwd(pwd, id) == 1)
		{
			if(pwd.equals(pwdr))
			{
				if(service.Deleteuser(pwd) == 1)
				{
					request.setAttribute("Result", true);
				}
				else 
				{	
					request.setAttribute("Result", false);
				}
			}
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/deleteresult.jsp");
		    rq.forward(request, response);
		} 
		else
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/deleteuser.jsp");
		    rq.forward(request, response);
		}	
	}

}